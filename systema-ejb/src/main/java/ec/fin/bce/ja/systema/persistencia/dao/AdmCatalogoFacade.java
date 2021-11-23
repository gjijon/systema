/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fin.bce.ja.systema.persistencia.dao;

import ec.fin.bce.ja.systema.persistencia.entities.administracion.AdmCatalogo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gabriel
 */
@Stateless
public class AdmCatalogoFacade extends AbstractFacade<AdmCatalogo> {

    @PersistenceContext(unitName = "systemAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdmCatalogoFacade() {
        super(AdmCatalogo.class);
    }

    public List<AdmCatalogo> obtenerTodos() {
        TypedQuery consulta = em.createNamedQuery("findAll", AdmCatalogo.class);
        return consulta.getResultList();
    }

    public List<AdmCatalogo> obtenerPorId(Integer id) {
        TypedQuery consulta = em.createNamedQuery("findByCatId", AdmCatalogo.class);
        consulta.setParameter("catId", id);
        return consulta.getResultList();
    }

    public List<AdmCatalogo> obtenerPorNombre(String nombre) {
        TypedQuery consulta = em.createNamedQuery("findByCatNombre", AdmCatalogo.class);
        consulta.setParameter("catNombre", nombre);
        return consulta.getResultList();
    }

    public List<AdmCatalogo> obtenerPorDescripcion(String descripcion) {
        TypedQuery consulta = em.createNamedQuery("findByCatDescripcion", AdmCatalogo.class);
        consulta.setParameter("catDescripcion", descripcion);
        return consulta.getResultList();
    }

    public List<AdmCatalogo> obtenerPorTodosParametros(Integer id, String nombre, String descripcion) {
        TypedQuery consulta = em.createNamedQuery("findByAllParameters", AdmCatalogo.class);
        consulta.setParameter("catId", id);
        consulta.setParameter("catNombre", nombre);
        consulta.setParameter("catDescripcion", descripcion);
        return consulta.getResultList();
    }

}
