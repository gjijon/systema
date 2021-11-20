/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fin.bce.ja.systema.persistencia.entities.seguridad;

import ec.fin.bce.ja.systema.persistencia.entities.administracion.AdmCatalogoDetalle;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "seg_usuario", catalog = "sch_seguridad")
@NamedQueries({
    @NamedQuery(name = "SegUsuario.findAll", query = "SELECT s FROM SegUsuario s"),
    @NamedQuery(name = "SegUsuario.findByUsuId", query = "SELECT s FROM SegUsuario s WHERE s.usuId = :usuId"),
    @NamedQuery(name = "SegUsuario.findByUsuUsuario", query = "SELECT s FROM SegUsuario s WHERE s.usuUsuario = :usuUsuario"),
    @NamedQuery(name = "SegUsuario.findByUsuClave", query = "SELECT s FROM SegUsuario s WHERE s.usuClave = :usuClave"),
    @NamedQuery(name = "SegUsuario.findByUsuFechaCaducidadClave", query = "SELECT s FROM SegUsuario s WHERE s.usuFechaCaducidadClave = :usuFechaCaducidadClave"),
    @NamedQuery(name = "SegUsuario.findByUsuFechaCambioClave", query = "SELECT s FROM SegUsuario s WHERE s.usuFechaCambioClave = :usuFechaCambioClave")})
public class SegUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usu_id")
    private Integer usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "usu_usuario")
    private String usuUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "usu_clave")
    private String usuClave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usu_fecha_caducidad_clave")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFechaCaducidadClave;
    @Column(name = "usu_fecha_cambio_clave")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFechaCambioClave;

    @JoinColumn(name = "per_id", referencedColumnName = "per_id")
    @OneToOne(optional = false)
    private SegPersona perId;

    @JoinColumn(name = "catdet_tipo_usuario_fk", referencedColumnName = "catdet_id")
    @ManyToOne(optional = false)
    private AdmCatalogoDetalle tipoUsuario;

    public SegUsuario() {
    }

    public SegUsuario(Integer usuId) {
        this.usuId = usuId;
    }

    public SegUsuario(Integer usuId, String usuUsuario, String usuClave, Date usuFechaCaducidadClave, int catdetTipoUsuarioFk) {
        this.usuId = usuId;
        this.usuUsuario = usuUsuario;
        this.usuClave = usuClave;
        this.usuFechaCaducidadClave = usuFechaCaducidadClave;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public Date getUsuFechaCaducidadClave() {
        return usuFechaCaducidadClave;
    }

    public void setUsuFechaCaducidadClave(Date usuFechaCaducidadClave) {
        this.usuFechaCaducidadClave = usuFechaCaducidadClave;
    }

    public Date getUsuFechaCambioClave() {
        return usuFechaCambioClave;
    }

    public void setUsuFechaCambioClave(Date usuFechaCambioClave) {
        this.usuFechaCambioClave = usuFechaCambioClave;
    }

    public AdmCatalogoDetalle getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(AdmCatalogoDetalle tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public SegPersona getPerId() {
        return perId;
    }

    public void setPerId(SegPersona perId) {
        this.perId = perId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuario)) {
            return false;
        }
        SegUsuario other = (SegUsuario) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.airhacks.SegUsuario[ usuId=" + usuId + " ]";
    }

}
