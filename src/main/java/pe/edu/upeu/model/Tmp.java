/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author server-itecs
 */
@Entity
@Table(name = "tmp")
@NamedQueries({
    @NamedQuery(name = "Tmp.findAll", query = "SELECT t FROM Tmp t")})
public class Tmp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tmp")
    private Integer idTmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_tmp")
    private int cantidadTmp;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_tmp")
    private Double precioTmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "session_id")
    private String sessionId;

    public Tmp() {
    }

    public Tmp(Integer idTmp) {
        this.idTmp = idTmp;
    }

    public Tmp(Integer idTmp, int idProducto, int cantidadTmp, String sessionId) {
        this.idTmp = idTmp;
        this.idProducto = idProducto;
        this.cantidadTmp = cantidadTmp;
        this.sessionId = sessionId;
    }

    public Integer getIdTmp() {
        return idTmp;
    }

    public void setIdTmp(Integer idTmp) {
        this.idTmp = idTmp;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadTmp() {
        return cantidadTmp;
    }

    public void setCantidadTmp(int cantidadTmp) {
        this.cantidadTmp = cantidadTmp;
    }

    public Double getPrecioTmp() {
        return precioTmp;
    }

    public void setPrecioTmp(Double precioTmp) {
        this.precioTmp = precioTmp;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTmp != null ? idTmp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tmp)) {
            return false;
        }
        Tmp other = (Tmp) object;
        if ((this.idTmp == null && other.idTmp != null) || (this.idTmp != null && !this.idTmp.equals(other.idTmp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.upeu.model.Tmp[ idTmp=" + idTmp + " ]";
    }
    
}
