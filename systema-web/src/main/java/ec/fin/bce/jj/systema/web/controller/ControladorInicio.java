package ec.fin.bce.jj.systema.web.controller;

import ec.fin.bce.ja.systema.persistencia.dao.AdmCatalogoFacade;
import ec.fin.bce.ja.systema.persistencia.entities.administracion.AdmCatalogo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
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
@Named(value = "controladorInicio")
@ViewScoped
public class ControladorInicio implements Serializable {

    private static final Logger LOG = Logger.getLogger(ControladorInicio.class.getName());

    @Inject
    private AdmCatalogoFacade catalogoFacade;
    
    @Inject
    private SessionManagedBean sessionManagedBean;

    private String nombre;
    private AdmCatalogo admCatalogoNuevo;
    private AdmCatalogo admCatalogoSeleccionado;
    private AdmCatalogo admCatalogoABorrar;
    private List<AdmCatalogo> admCatalogos;

    /**
     * Creates a new instance of ControladorInicio
     */
    public ControladorInicio() {
    }

    @PostConstruct
    public void init() {
        admCatalogoNuevo = new AdmCatalogo();
        admCatalogos = catalogoFacade.findAll();
        sessionManagedBean.setPantallaActual("Catálogos");
    }

    public void guardar() {
        try {
            if (admCatalogoSeleccionado == null) {
                catalogoFacade.create(admCatalogoNuevo);

            } else {
                catalogoFacade.edit(admCatalogoNuevo);
            }

            FacesContext.getCurrentInstance().addMessage("Guardando", new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado", "Guardando Catalogo"));

            admCatalogoNuevo = new AdmCatalogo();
            admCatalogoSeleccionado = null;
            admCatalogos = catalogoFacade.findAll();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "error", e);
            FacesContext.getCurrentInstance().addMessage("Error guardando", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Guardando Catalogo"));
        }
    }

    public void borrar() {
        if(admCatalogoABorrar != null ) {
            catalogoFacade.remove(admCatalogoABorrar);
            LOG.info(String.format("Objeto: %s", admCatalogoABorrar));
            admCatalogos = catalogoFacade.findAll();
        }
    }

    public void onRowSelect(SelectEvent<AdmCatalogo> event) {
        FacesMessage mensaje = new FacesMessage();
        mensaje.setDetail(String.format("Seleccionado: %s", event.getObject().getCatNombre()));
        mensaje.setSeverity(FacesMessage.SEVERITY_INFO);
        mensaje.setSummary("Catalogo");
        FacesContext.getCurrentInstance().addMessage("Seleccionado", mensaje);
        admCatalogoSeleccionado = event.getObject();
        admCatalogoNuevo = event.getObject();
    }

    public void onRowUnselect(UnselectEvent<AdmCatalogo> event) {
        LOG.log(Level.INFO, "no seleccionado: {0}", event.getObject().getCatNombre());
        admCatalogoSeleccionado = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public AdmCatalogo getAdmCatalogoNuevo() {
        return admCatalogoNuevo;
    }

    public void setAdmCatalogoNuevo(AdmCatalogo admCatalogoNuevo) {
        this.admCatalogoNuevo = admCatalogoNuevo;
    }

    public List<AdmCatalogo> getAdmCatalogos() {
        return admCatalogos;
    }

    public void setAdmCatalogos(List<AdmCatalogo> admCatalogos) {
        this.admCatalogos = admCatalogos;
    }

    public AdmCatalogo getAdmCatalogoSeleccionado() {
        return admCatalogoSeleccionado;
    }

    public void setAdmCatalogoSeleccionado(AdmCatalogo admCatalogoSeleccionado) {
        this.admCatalogoSeleccionado = admCatalogoSeleccionado;
    }

    public AdmCatalogo getAdmCatalogoABorrar() {
        return admCatalogoABorrar;
    }

    public void setAdmCatalogoABorrar(AdmCatalogo admCatalogoABorrar) {
        this.admCatalogoABorrar = admCatalogoABorrar;
    }

}
