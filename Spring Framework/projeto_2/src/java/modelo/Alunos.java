/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
@Table(name = "alunos")
@NamedQueries({
    @NamedQuery(name = "Alunos.listarTodos", query = "SELECT a FROM Alunos a"),
    @NamedQuery(name = "Alunos.findByIdalunos", query = "SELECT a FROM Alunos a WHERE a.id = :idalunos"),
    @NamedQuery(name = "Alunos.findByNome", query = "SELECT a FROM Alunos a WHERE a.nome = :nome"),
    @NamedQuery(name = "Alunos.findByCurso", query = "SELECT a FROM Alunos a WHERE a.curso = :curso"),
    @NamedQuery(name = "Alunos.findByCpf", query = "SELECT a FROM Alunos a WHERE a.cpf = :cpf"),
    @NamedQuery(name = "Alunos.findByEmail", query = "SELECT a FROM Alunos a WHERE a.email = :email"),
    @NamedQuery(name = "Alunos.findByLogin", query = "SELECT a FROM Alunos a WHERE a.login = :login"),
    @NamedQuery(name = "Alunos.findBySenha", query = "SELECT a FROM Alunos a WHERE a.senha = :senha")})
public class Alunos implements Serializable, Base {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idalunos")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "curso")
    private String curso;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunos")
    private List<Matriculas> matriculasList;

    public Alunos() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Matriculas> getMatriculasList() {
        return matriculasList;
    }

    public void setMatriculasList(List<Matriculas> matriculasList) {
        this.matriculasList = matriculasList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Alunos other = (Alunos) obj;
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
