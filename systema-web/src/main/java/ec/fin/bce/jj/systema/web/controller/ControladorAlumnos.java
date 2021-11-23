/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fin.bce.jj.systema.web.controller;

import ec.fin.bce.ja.systema.persistencia.dao.AcaAlumnoFacade;
import ec.fin.bce.ja.systema.persistencia.dao.AdmCatalogoDetalleFacade;
import ec.fin.bce.ja.systema.persistencia.dao.SegUsuarioFacade;
import ec.fin.bce.ja.systema.persistencia.entities.academico.AcaAlumno;
import ec.fin.bce.ja.systema.persistencia.entities.administracion.AdmCatalogo;
import ec.fin.bce.ja.systema.persistencia.entities.seguridad.SegUsuario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Gabriel
 */
@Named(value = "controladorAlumnos")
@ViewScoped
public class ControladorAlumnos implements Serializable {

    private static final Logger LOG = Logger.getLogger(ControladorAlumnos.class.getName());

    @Inject
    private AcaAlumnoFacade alumnoFacade;

    @Inject
    private SegUsuarioFacade usuarioFacade;
    @Inject
    private AdmCatalogoDetalleFacade catalogoDetalleFacade;

    private AcaAlumno acaAlumnoNuevo;
    private AcaAlumno acaAlumnoSeleccionado;
    private AcaAlumno acaAlumnoABorrar;
    private SegUsuario usuarioAsociadoParaNuevo;
    private List<AcaAlumno> alumnos = new ArrayList<>(0);
    private List<SegUsuario> usuarios = new ArrayList<>(0);
    private SegUsuario usuarioNuevo;

    /**
     * Creates a new instance of ControladorAlumnos
     */
    public ControladorAlumnos() {
    }

    @PostConstruct
    public void init() {
        reset();
        alumnos = alumnoFacade.findAll();
        usuarios = usuarioFacade.findAll();
    }

    public List<AcaAlumno> getAlumnos() {
        return alumnos;
    }

    public void guardarUsuario() {
        
        try {
            usuarioNuevo.setUsuFechaCambioClave(Date.from(LocalDateTime.now().toInstant(ZoneOffset.of("-05:00"))));
            usuarioNuevo.setUsuFechaCaducidadClave(Date.from(LocalDateTime.now().plusMonths(2).toInstant(ZoneOffset.of("-05:00"))));
            usuarioNuevo.setTipoUsuario(catalogoDetalleFacade.find(1));
            usuarioFacade.create(usuarioNuevo);

            FacesContext.getCurrentInstance().addMessage("Guardando", new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado", "Guardando Usuario"));

            reset();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "error", e);
            FacesContext.getCurrentInstance().addMessage("Error guardando", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Guardando Usuario"));
        }
    }

    public void guardar() {
        try {
            acaAlumnoNuevo.setSegUsuario(usuarioAsociadoParaNuevo);
            acaAlumnoNuevo.setAlnFechaActualiza(Timestamp.valueOf(LocalDateTime.now()));
            usuarioAsociadoParaNuevo.setAlumno(acaAlumnoNuevo);
            if (acaAlumnoSeleccionado == null) {
                alumnoFacade.create(acaAlumnoNuevo);

            } else {
                alumnoFacade.edit(acaAlumnoNuevo);
            }

            FacesContext.getCurrentInstance().addMessage("Guardando", new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado", "Guardando Alumno"));

            reset();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "error", e);
            FacesContext.getCurrentInstance().addMessage("Error guardando", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Guardando Alumno"));
        }
    }

    public void reset() {
        acaAlumnoNuevo = new AcaAlumno();
        acaAlumnoSeleccionado = null;
        alumnos = alumnoFacade.findAll();
        usuarios = usuarioFacade.findAll();
        usuarioAsociadoParaNuevo = null;
        usuarioNuevo = new SegUsuario();
    }

    public void borrar() {
        if (acaAlumnoABorrar != null) {
            alumnoFacade.remove(acaAlumnoABorrar);
            LOG.info(String.format("Objeto: %s", acaAlumnoABorrar));
            alumnos = alumnoFacade.findAll();
        }
    }

    public void onRowSelect(SelectEvent<AcaAlumno> event) {
        FacesMessage mensaje = new FacesMessage();
        mensaje.setDetail(String.format("Seleccionado: %s %s", event.getObject().getAlnNombre(), event.getObject().getAlnApellido()));
        mensaje.setSeverity(FacesMessage.SEVERITY_INFO);
        mensaje.setSummary("Alumno");
        FacesContext.getCurrentInstance().addMessage("Seleccionado", mensaje);
        acaAlumnoSeleccionado = event.getObject();
        usuarioAsociadoParaNuevo = acaAlumnoSeleccionado.getSegUsuario();
        acaAlumnoNuevo = event.getObject();
    }

    public void onRowUnselect(UnselectEvent<AdmCatalogo> event) {
        LOG.log(Level.INFO, "no seleccionado: {0}", event.getObject().getCatNombre());
        acaAlumnoSeleccionado = null;
    }

    public void setAlumnos(List<AcaAlumno> alumnos) {
        this.alumnos = alumnos;
    }

    public AcaAlumno getAcaAlumnoNuevo() {
        return acaAlumnoNuevo;
    }

    public void setAcaAlumnoNuevo(AcaAlumno acaAlumnoNuevo) {
        this.acaAlumnoNuevo = acaAlumnoNuevo;
    }

    public AcaAlumno getAcaAlumnoSeleccionado() {
        return acaAlumnoSeleccionado;
    }

    public void setAcaAlumnoSeleccionado(AcaAlumno acaAlumnoSeleccionado) {
        this.acaAlumnoSeleccionado = acaAlumnoSeleccionado;
    }

    public AcaAlumno getAcaAlumnoABorrar() {
        return acaAlumnoABorrar;
    }

    public void setAcaAlumnoABorrar(AcaAlumno acaAlumnoABorrar) {
        this.acaAlumnoABorrar = acaAlumnoABorrar;
    }

    public SegUsuario getUsuarioAsociadoParaNuevo() {
        return usuarioAsociadoParaNuevo;
    }

    public void setUsuarioAsociadoParaNuevo(SegUsuario usuarioAsociadoParaNuevo) {
        this.usuarioAsociadoParaNuevo = usuarioAsociadoParaNuevo;
    }

    public List<SegUsuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<SegUsuario> usuarios) {
        this.usuarios = usuarios;
    }

    public SegUsuario getUsuarioNuevo() {
        return usuarioNuevo;
    }

    public void setUsuarioNuevo(SegUsuario usuarioNuevo) {
        this.usuarioNuevo = usuarioNuevo;
    }

}
