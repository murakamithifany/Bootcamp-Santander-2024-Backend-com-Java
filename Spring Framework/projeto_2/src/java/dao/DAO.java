/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Base;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author vfmaz
 * @param <T>
 */
public class DAO<T extends Base> implements Serializable {

    private static final long serialVersionUID = 1L;

    public T buscarPorId(Class<T> classe, long id) {
        EntityManager gerente = GerenciadorConexao.getGerente();
        return gerente.find(classe, id);
    }

    public void salvar(T dados) {
        EntityManager gerente = GerenciadorConexao.getGerente();
        gerente.getTransaction().begin();
        try {
            if (dados.getIdLong() == null) {
                System.out.println(dados);
                gerente.persist(dados);
            } else {
                gerente.merge(dados);
            }
            gerente.getTransaction().commit();

        } catch (Exception e) {
            gerente.getTransaction().rollback();
        }
        gerente.close();
    }

    public void remover(Class<T> classe, Long id) {
        EntityManager gerente = GerenciadorConexao.getGerente();

        try {
            gerente.getTransaction().begin();
            T dados = gerente.find(classe, id);
            gerente.remove(dados);
            gerente.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            gerente.getTransaction().rollback();
        }
        gerente.close();
    }

    public List<T> buscarTodos(String sql) {
        EntityManager gerente = GerenciadorConexao.getGerente();
        Query query = gerente.createQuery(sql);
        return query.getResultList();
    }



}
