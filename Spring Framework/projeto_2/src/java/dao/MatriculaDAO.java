/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Matriculas;

public class MatriculaDAO implements Serializable {

    public void salvar(Matriculas dados) {
       //criando o gerente de entidade
        EntityManager gerente = GerenciadorConexao.getGerente();
        
        //inicia uma transação com o banco de dados
        gerente.getTransaction().begin();
        
        //salvar o fornecedor no banco de dados
        gerente.persist(dados);
        
        //finalizar a transação
        gerente.getTransaction().commit();
        
        //fecha a conexão
        gerente.clear();
    }

    public void remover(Class<Matriculas> classe, Long id) {
        EntityManager gerente = GerenciadorConexao.getGerente();

        try {
            gerente.getTransaction().begin();
            Matriculas dados = gerente.find(classe, id);
            gerente.remove(dados);
            gerente.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            gerente.getTransaction().rollback();
        }
        gerente.close();
    }
    
        public List<Matriculas> buscarTodos(String sql) {
        EntityManager gerente = GerenciadorConexao.getGerente();
        Query query = gerente.createQuery(sql);
        return query.getResultList();
    }
}
