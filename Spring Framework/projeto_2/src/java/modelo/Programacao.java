/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author noteb
 */
@Entity
@Table(name = "programacao")
@NamedQueries({
    @NamedQuery(name = "Programacao.findAll", query = "SELECT p FROM Programacao p"),
    @NamedQuery(name = "Programacao.findByIdprogramacao", query = "SELECT p FROM Programacao p WHERE p.id = :idprogramacao"),
    @NamedQuery(name = "Programacao.findByNome", query = "SELECT p FROM Programacao p WHERE p.nome = :nome"),
    @NamedQuery(name = "Programacao.listarSemanaAtiva", query = "SELECT p FROM Programacao p WHERE p.status = :status")})
public class Programacao implements Serializable,Base {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprogramacao")
    private Long id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "local")
    private String local;
    
    @Column(name = "ch")
    private Integer ch;
    
    @Column(name = "qtdevagas")
    private Integer qtdevagas;
    
    @Column(name = "qtdematriculados")
    private Integer qtdematriculados;
    
    @Column(name = "status")
    private String status;
    
    @JoinColumn(name = "idministrante", referencedColumnName = "idministrante")
    @ManyToOne(optional = false)
    private Ministrante idministrante;
    
    @JoinColumn(name = "idSemana", referencedColumnName = "idSemana")
    @ManyToOne(optional = false)
    private Semana idSemana;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programacao")
    private List<Matriculas> matriculasList;

    public Programacao() {
    }

    public void setId(Long id) {
        this.id = id;
    }

   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getCh() {
        return ch;
    }

    public void setCh(Integer ch) {
        this.ch = ch;
    }

    public Integer getQtdevagas() {
        return qtdevagas;
    }

    public void setQtdevagas(Integer qtdevagas) {
        this.qtdevagas = qtdevagas;
    }

    public Integer getQtdematriculados() {
        return qtdematriculados;
    }

    public void setQtdematriculados(Integer qtdematriculados) {
        this.qtdematriculados = qtdematriculados;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Ministrante getIdministrante() {
        return idministrante;
    }

    public void setIdministrante(Ministrante idministrante) {
        this.idministrante = idministrante;
    }

    public Semana getIdSemana() {
        return idSemana;
    }

    public void setIdSemana(Semana idSemana) {
        this.idSemana = idSemana;
    }

    public List<Matriculas> getMatriculasList() {
        return matriculasList;
    }

    public void setMatriculasList(List<Matriculas> matriculasList) {
        this.matriculasList = matriculasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programacao)) {
            return false;
        }
        Programacao other = (Programacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Programacao[ idprogramacao=" + id + " ]";
    }

    @Override
    public Long getIdLong() {
        return this.id;
    }
    
    
}
