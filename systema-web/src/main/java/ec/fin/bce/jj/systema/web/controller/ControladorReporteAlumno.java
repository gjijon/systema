package ec.fin.bce.jj.systema.web.controller;

import ec.fin.bce.ja.systema.persistencia.dao.AcaAlumnoFacade;
import ec.fin.bce.ja.systema.persistencia.entities.academico.AcaAlumno;
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
@Named(value = "reporteAlumno")
@ViewScoped
public class ControladorReporteAlumno implements Serializable {

    @Inject
    private AcaAlumnoFacade alumnoFacade;
    @Inject
    private SessionManagedBean sessionManagedBean;

    private AcaAlumno alumnoConsulta;
    private List<String> menu;
    private String seleccion;
    private List<AcaAlumno> listaAlumnos;

    @PostConstruct
    public void init() {
        inicializar();
        menu = Arrays.asList(new String[]{"IDENTIFICACION", "NOMBRE", "APELLIDO", "VARIOS", "TODOS"});
    }

    public void consultar() {
        switch (seleccion) {
            case "IDENTIFICACION":
                listaAlumnos = alumnoFacade.obtenerPorId(alumnoConsulta.getAlnIdentificacion());
                break;
            case "NOMBRE":
                listaAlumnos = alumnoFacade.obtenerPorNombre(alumnoConsulta.getAlnNombre());
                break;
            case "APELLIDO":
                listaAlumnos = alumnoFacade.obtenerPorApellido(alumnoConsulta.getAlnApellido());
                break;
            case "VARIOS":
                listaAlumnos = alumnoFacade.obtenerPorTodosParametros(alumnoConsulta.getAlnIdentificacion(), alumnoConsulta.getAlnNombre(), alumnoConsulta.getAlnApellido());
                break;
            default:
                listaAlumnos = alumnoFacade.findAll();
                break;
        }
        FacesContext.getCurrentInstance().addMessage("Resultados: ", new FacesMessage(FacesMessage.SEVERITY_INFO, "Elementos encontrados: ", String.valueOf(listaAlumnos.size())));
    }
    
    public void inicializar() {
        listaAlumnos = new ArrayList<>();
        alumnoConsulta = new AcaAlumno();
        seleccion = "";
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

    public AcaAlumno getAlumnoConsulta() {
        return alumnoConsulta;
    }

    public void setAlumnoConsulta(AcaAlumno alumnoConsulta) {
        this.alumnoConsulta = alumnoConsulta;
    }

    public List<AcaAlumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(List<AcaAlumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

}
