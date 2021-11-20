/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ec.fin.bce.ja.systema.persistencia.ping;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Gabriel
 */
@Stateless
@LocalBean
public class SAPing {

    public String pingSimple(final String simple) {
        return "Simple: " + simple;
    }
}
