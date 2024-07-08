/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author noteb
 */
@Entity
@Table(name = "matriculas")
@NamedQueries({
    @NamedQuery(name = "Matriculas.findAll", query = "SELECT m FROM Matriculas m"),
    @NamedQuery(name = "Matriculas.findByIdprogramacao", query = "SELECT m FROM Matriculas m WHERE m.matriculasPK.idprogramacao = :idprogramacao"),
    @NamedQuery(name = "Matriculas.findByIdalunos", query = "SELECT m FROM Matriculas m WHERE m.matriculasPK.idalunos = :idalunos"),
    @NamedQuery(name = "Matriculas.findByPresentemanha", query = "SELECT m FROM Matriculas m WHERE m.presentemanha = :presentemanha"),
    @NamedQuery(name = "Matriculas.findByPresentetarde", query = "SELECT m FROM Matriculas m WHERE m.presentetarde = :presentetarde")})
public class Matriculas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatriculasPK matriculasPK;
    @Column(name = "presentemanha")
    private String presentemanha;
    @Column(name = "presentetarde")
    private String presentetarde;
    @JoinColumn(name = "idalunos", referencedColumnName = "idalunos", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alunos alunos;
    @JoinColumn(name = "idprogramacao", referencedColumnName = "idprogramacao", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Programacao programacao;

    public Matriculas() {
    }

    public Matriculas(MatriculasPK matriculasPK) {
        this.matriculasPK = matriculasPK;
    }

    public Matriculas(int idprogramacao, int idalunos) {
        this.matriculasPK = new MatriculasPK(idprogramacao, idalunos);
    }

    public MatriculasPK getMatriculasPK() {
        return matriculasPK;
    }

    public void setMatriculasPK(MatriculasPK matriculasPK) {
        this.matriculasPK = matriculasPK;
    }

    public String getPresentemanha() {
        return presentemanha;
    }

    public void setPresentemanha(String presentemanha) {
        this.presentemanha = presentemanha;
    }

    public String getPresentetarde() {
        return presentetarde;
    }

    public void setPresentetarde(String presentetarde) {
        this.presentetarde = presentetarde;
    }

    public Alunos getAlunos() {
        return alunos;
    }

    public void setAlunos(Alunos alunos) {
        this.alunos = alunos;
    }

    public Programacao getProgramacao() {
        return programacao;
    }

    public void setProgramacao(Programacao programacao) {
        this.programacao = programacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculasPK != null ? matriculasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matriculas)) {
            return false;
        }
        Matriculas other = (Matriculas) object;
        if ((this.matriculasPK == null && other.matriculasPK != null) || (this.matriculasPK != null && !this.matriculasPK.equals(other.matriculasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Matriculas[ matriculasPK=" + matriculasPK + " ]";
    }
    
}
