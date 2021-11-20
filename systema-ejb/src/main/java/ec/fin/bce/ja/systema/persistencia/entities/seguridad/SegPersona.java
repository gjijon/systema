/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fin.bce.ja.systema.persistencia.entities.seguridad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "seg_persona", schema = "sch_seguridad")
@NamedQueries({
    @NamedQuery(name = "SegPersona.findAll", query = "SELECT s FROM SegPersona s"),
    @NamedQuery(name = "SegPersona.findByPerId", query = "SELECT s FROM SegPersona s WHERE s.perId = :perId"),
    @NamedQuery(name = "SegPersona.findByPerNombres", query = "SELECT s FROM SegPersona s WHERE s.perNombres = :perNombres"),
    @NamedQuery(name = "SegPersona.findByPerApellidos", query = "SELECT s FROM SegPersona s WHERE s.perApellidos = :perApellidos"),
    @NamedQuery(name = "SegPersona.findByPerIdentificacion", query = "SELECT s FROM SegPersona s WHERE s.perIdentificacion = :perIdentificacion"),
    @NamedQuery(name = "SegPersona.findByPerCorreo", query = "SELECT s FROM SegPersona s WHERE s.perCorreo = :perCorreo"),
    @NamedQuery(name = "SegPersona.findByPerDireccion", query = "SELECT s FROM SegPersona s WHERE s.perDireccion = :perDireccion"),
    @NamedQuery(name = "SegPersona.findByPerTelefono", query = "SELECT s FROM SegPersona s WHERE s.perTelefono = :perTelefono")})
public class SegPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "per_id")
    private Integer perId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "per_nombres")
    private String perNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "per_apellidos")
    private String perApellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "per_identificacion")
    private String perIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "per_correo")
    private String perCorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "per_direccion")
    private String perDireccion;
    @Size(max = 15)
    @Column(name = "per_telefono")
    private String perTelefono;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "perId")
    private SegUsuario segUsuario;

    public SegPersona() {
    }

    public SegPersona(Integer perId) {
        this.perId = perId;
    }

    public SegPersona(Integer perId, String perNombres, String perApellidos, String perIdentificacion, String perCorreo, String perDireccion) {
        this.perId = perId;
        this.perNombres = perNombres;
        this.perApellidos = perApellidos;
        this.perIdentificacion = perIdentificacion;
        this.perCorreo = perCorreo;
        this.perDireccion = perDireccion;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerNombres() {
        return perNombres;
    }

    public void setPerNombres(String perNombres) {
        this.perNombres = perNombres;
    }

    public String getPerApellidos() {
        return perApellidos;
    }

    public void setPerApellidos(String perApellidos) {
        this.perApellidos = perApellidos;
    }

    public String getPerIdentificacion() {
        return perIdentificacion;
    }

    public void setPerIdentificacion(String perIdentificacion) {
        this.perIdentificacion = perIdentificacion;
    }

    public String getPerCorreo() {
        return perCorreo;
    }

    public void setPerCorreo(String perCorreo) {
        this.perCorreo = perCorreo;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public String getPerTelefono() {
        return perTelefono;
    }

    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }

    @XmlTransient
    public SegUsuario getSegUsuario() {
        return segUsuario;
    }

    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPersona)) {
            return false;
        }
        SegPersona other = (SegPersona) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.airhacks.SegPersona[ perId=" + perId + " ]";
    }
    
}
