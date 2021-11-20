/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fin.bce.ja.systema.persistencia.entities.administracion;

import ec.fin.bce.ja.systema.persistencia.entities.seguridad.SegUsuario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "adm_catalogo_detalle", catalog = "sch_administracion")
@NamedQueries({
    @NamedQuery(name = "AdmCatalogoDetalle.findAll", query = "SELECT a FROM AdmCatalogoDetalle a"),
    @NamedQuery(name = "AdmCatalogoDetalle.findByCatdetId", query = "SELECT a FROM AdmCatalogoDetalle a WHERE a.catdetId = :catdetId"),
    @NamedQuery(name = "AdmCatalogoDetalle.findByCatdetNombre", query = "SELECT a FROM AdmCatalogoDetalle a WHERE a.catdetNombre = :catdetNombre"),
    @NamedQuery(name = "AdmCatalogoDetalle.findByCatdetDescripcion", query = "SELECT a FROM AdmCatalogoDetalle a WHERE a.catdetDescripcion = :catdetDescripcion")})
public class AdmCatalogoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "catdet_id")
    private Integer catdetId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "catdet_nombre")
    private String catdetNombre;
    @Size(max = 200)
    @Column(name = "catdet_descripcion")
    private String catdetDescripcion;
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @ManyToOne(optional = false)
    private AdmCatalogo catId;

    @OneToMany(mappedBy = "tipoUsuario")
    private List<SegUsuario> segUsuarios;

    public AdmCatalogoDetalle() {
    }

    public AdmCatalogoDetalle(Integer catdetId) {
        this.catdetId = catdetId;
    }

    public AdmCatalogoDetalle(Integer catdetId, String catdetNombre) {
        this.catdetId = catdetId;
        this.catdetNombre = catdetNombre;
    }

    public Integer getCatdetId() {
        return catdetId;
    }

    public void setCatdetId(Integer catdetId) {
        this.catdetId = catdetId;
    }

    public String getCatdetNombre() {
        return catdetNombre;
    }

    public void setCatdetNombre(String catdetNombre) {
        this.catdetNombre = catdetNombre;
    }

    public String getCatdetDescripcion() {
        return catdetDescripcion;
    }

    public void setCatdetDescripcion(String catdetDescripcion) {
        this.catdetDescripcion = catdetDescripcion;
    }

    public AdmCatalogo getCatId() {
        return catId;
    }

    public void setCatId(AdmCatalogo catId) {
        this.catId = catId;
    }

    public List<SegUsuario> getSegUsuarios() {
        return segUsuarios;
    }

    public void setSegUsuarios(List<SegUsuario> segUsuarios) {
        this.segUsuarios = segUsuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catdetId != null ? catdetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmCatalogoDetalle)) {
            return false;
        }
        AdmCatalogoDetalle other = (AdmCatalogoDetalle) object;
        if ((this.catdetId == null && other.catdetId != null) || (this.catdetId != null && !this.catdetId.equals(other.catdetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AdmCatalogoDetalle[ catdetId=" + catdetId + " ]";
    }

}
