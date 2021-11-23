/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fin.bce.ja.systema.persistencia.entities.administracion;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "adm_catalogo", catalog = "sch_administracion")
@NamedQueries({
    @NamedQuery(name = "findAll", query = "SELECT a FROM AdmCatalogo a"),
    @NamedQuery(name = "findByCatId", query = "SELECT a FROM AdmCatalogo a WHERE a.catId = :catId"),
    @NamedQuery(name = "findByCatNombre", query = "SELECT a FROM AdmCatalogo a WHERE a.catNombre = :catNombre"),
    @NamedQuery(name = "findByCatDescripcion", query = "SELECT a FROM AdmCatalogo a WHERE a.catDescripcion = :catDescripcion"),
    @NamedQuery(name = "findByAllParameters", query = "SELECT a FROM AdmCatalogo a WHERE a.catDescripcion = :catDescripcion and a.catId = :catId and a.catNombre = :catNombre")
})
public class AdmCatalogo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cat_id")
    private Integer catId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "cat_nombre")
    private String catNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "cat_descripcion")
    private String catDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catId")
    private List<AdmCatalogoDetalle> admCatalogoDetalleList;

    public AdmCatalogo() {
    }

    public AdmCatalogo(Integer catId) {
        this.catId = catId;
    }

    public AdmCatalogo(Integer catId, String catNombre, String catDescripcion) {
        this.catId = catId;
        this.catNombre = catNombre;
        this.catDescripcion = catDescripcion;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

    public String getCatDescripcion() {
        return catDescripcion;
    }

    public void setCatDescripcion(String catDescripcion) {
        this.catDescripcion = catDescripcion;
    }

    @XmlTransient
    public List<AdmCatalogoDetalle> getAdmCatalogoDetalleList() {
        return admCatalogoDetalleList;
    }

    public void setAdmCatalogoDetalleList(List<AdmCatalogoDetalle> admCatalogoDetalleList) {
        this.admCatalogoDetalleList = admCatalogoDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catId != null ? catId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmCatalogo)) {
            return false;
        }
        AdmCatalogo other = (AdmCatalogo) object;
        if ((this.catId == null && other.catId != null) || (this.catId != null && !this.catId.equals(other.catId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AdmCatalogo[ catId=" + catId + " ]";
    }
    
}
