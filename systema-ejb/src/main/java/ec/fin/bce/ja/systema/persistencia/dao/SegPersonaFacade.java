/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fin.bce.ja.systema.persistencia.dao;

import ec.fin.bce.ja.systema.persistencia.entities.seguridad.SegPersona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Gabriel
 */
@Stateless
public class SegPersonaFacade extends AbstractFacade<SegPersona> {

    @PersistenceContext(unitName = "systemAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegPersonaFacade() {
        super(SegPersona.class);
    }
    
}
