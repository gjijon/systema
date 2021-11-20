/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fin.bce.jj.systema.web.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Gabriel
 */
@Named(value = "sessionManagedBean")
@SessionScoped
public class SessionManagedBean implements Serializable {

    private String pantallaActual;
    /**
     * Creates a new instance of SessionManagedBean
     */
    public SessionManagedBean() {
    }

    public String getPantallaActual() {
        return pantallaActual;
    }

    public void setPantallaActual(String pantallaActual) {
        this.pantallaActual = pantallaActual;
    }
    
}
