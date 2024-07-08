/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author noteb
 */
@Embeddable
public class MatriculasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idprogramacao")
    private int idprogramacao;
    @Basic(optional = false)
    @Column(name = "idalunos")
    private int idalunos;

    public MatriculasPK() {
    }

    public MatriculasPK(int idprogramacao, int idalunos) {
        this.idprogramacao = idprogramacao;
        this.idalunos = idalunos;
    }

    public int getIdprogramacao() {
        return idprogramacao;
    }

    public void setIdprogramacao(int idprogramacao) {
        this.idprogramacao = idprogramacao;
    }

    public int getIdalunos() {
        return idalunos;
    }

    public void setIdalunos(int idalunos) {
        this.idalunos = idalunos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idprogramacao;
        hash += (int) idalunos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatriculasPK)) {
            return false;
        }
        MatriculasPK other = (MatriculasPK) object;
        if (this.idprogramacao != other.idprogramacao) {
            return false;
        }
        if (this.idalunos != other.idalunos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.MatriculasPK[ idprogramacao=" + idprogramacao + ", idalunos=" + idalunos + " ]";
    }
    
}
