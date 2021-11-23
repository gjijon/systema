package ec.fin.bce.jj.systema.web.controller;

import ec.fin.bce.ja.systema.persistencia.dao.AdmCatalogoFacade;
import ec.fin.bce.ja.systema.persistencia.entities.administracion.AdmCatalogo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Grupo 1
 */
@Named(value = "reporteCatalogo")
@ViewScoped
public class ControladorReporteCatalogo implements Serializable {

    @Inject
    private AdmCatalogoFacade catalogoFacade;
    @Inject
    private SessionManagedBean sessionManagedBean;

    private AdmCatalogo catalogoConsulta;
    private List<String> menu;
    private String seleccion;
    private List<AdmCatalogo> listaCatalogos;

    @PostConstruct
    public void init() {
        inicializar();
        menu = Arrays.asList(new String[]{"IDENTIFICACION", "NOMBRE", "DESCRIPCION", "VARIOS", "TODOS"});
    }

    public void consultar() {
        switch (seleccion) {
            case "IDENTIFICACION":
                listaCatalogos = catalogoFacade.obtenerPorId(catalogoConsulta.getCatId());
                break;
            case "NOMBRE":
                listaCatalogos = catalogoFacade.obtenerPorNombre(catalogoConsulta.getCatNombre());
                break;
            case "DESCRIPCION":
                listaCatalogos = catalogoFacade.obtenerPorDescripcion(catalogoConsulta.getCatDescripcion());
                break;
            case "VARIOS":
                listaCatalogos = catalogoFacade.obtenerPorTodosParametros(catalogoConsulta.getCatId(), catalogoConsulta.getCatNombre(), catalogoConsulta.getCatDescripcion());
                break;
            default:
                listaCatalogos = catalogoFacade.obtenerTodos();
                break;
        }
        FacesContext.getCurrentInstance().addMessage("Resultados: ", new FacesMessage(FacesMessage.SEVERITY_INFO, "Elementos encontrados: ", String.valueOf(listaCatalogos.size())));
    }
    
    public void inicializar() {
        listaCatalogos = new ArrayList<>();
        catalogoConsulta = new AdmCatalogo();
        seleccion = "";
    }

    public AdmCatalogo getCatalogoConsulta() {
        return catalogoConsulta;
    }

    public void setCatalogoConsulta(AdmCatalogo catalogoConsulta) {
        this.catalogoConsulta = catalogoConsulta;
    }

    public SessionManagedBean getSessionManagedBean() {
        return sessionManagedBean;
    }

    public void setSessionManagedBean(SessionManagedBean sessionManagedBean) {
        this.sessionManagedBean = sessionManagedBean;
    }

    public List<String> getMenu() {
        return menu;
    }

    public void setMenu(List<String> menu) {
        this.menu = menu;
    }

    public String getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }

    public List<AdmCatalogo> getListaCatalogos() {
        return listaCatalogos;
    }

    public void setListaCatalogos(List<AdmCatalogo> listaCatalogos) {
        this.listaCatalogos = listaCatalogos;
    }
    
}
