/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fin.bce.jj.systema.web.controller;

import ec.fin.bce.ja.systema.persistencia.dao.AcaAlumnoFacade;
import ec.fin.bce.ja.systema.persistencia.entities.academico.AcaAlumno;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

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

    private AcaAlumno acaAlumnoNuevo;
    private List<AcaAlumno> alumnos = new ArrayList<>(0);

    /**
     * Creates a new instance of ControladorAlumnos
     */
    public ControladorAlumnos() {
    }

    @PostConstruct
    public void init() {
        reset();
        alumnos = alumnoFacade.findAll();
    }

    public List<AcaAlumno> getAlumnos() {
        return alumnos;
    }

    private void reset() {
        acaAlumnoNuevo = new AcaAlumno();
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

}
