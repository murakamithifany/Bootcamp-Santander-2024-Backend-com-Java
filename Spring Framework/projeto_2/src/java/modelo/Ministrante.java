/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author noteb
 */
@Entity
@Table(name = "ministrante")
@NamedQueries({
    @NamedQuery(name = "Ministrante.listarTodos", query = "SELECT m FROM Ministrante m"),
    @NamedQuery(name = "Ministrante.findByIdministrante", query = "SELECT m FROM Ministrante m WHERE m.id = :idministrante"),
    @NamedQuery(name = "Ministrante.findByNome", query = "SELECT m FROM Ministrante m WHERE m.nome = :nome"),
    @NamedQuery(name = "Ministrante.findByCargo", query = "SELECT m FROM Ministrante m WHERE m.cargo = :cargo"),
    @NamedQuery(name = "Ministrante.findByEntidade", query = "SELECT m FROM Ministrante m WHERE m.entidade = :entidade"),
    @NamedQuery(name = "Ministrante.findByEmail", query = "SELECT m FROM Ministrante m WHERE m.email = :email"),
    @NamedQuery(name = "Ministrante.findByCpf", query = "SELECT m FROM Ministrante m WHERE m.cpf = :cpf")})
public class Ministrante implements Serializable, Base {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idministrante")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "entidade")
    private String entidade;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idministrante")
    private List<Programacao> programacaoList;

    public Ministrante() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Programacao> getProgramacaoList() {
        return programacaoList;
    }

    public void setProgramacaoList(List<Programacao> programacaoList) {
        this.programacaoList = programacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ministrante other = (Ministrante) obj;
        return Objects.equals(this.id, other.id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getIdLong() {
        return this.id;
    }
}
