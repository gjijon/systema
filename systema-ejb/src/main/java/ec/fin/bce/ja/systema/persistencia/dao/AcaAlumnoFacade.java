/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fin.bce.ja.systema.persistencia.dao;

import ec.fin.bce.ja.systema.persistencia.entities.academico.AcaAlumno;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Gabriel
 */
@Stateless
public class AcaAlumnoFacade extends AbstractFacade<AcaAlumno> {

    @PersistenceContext(unitName = "systemAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcaAlumnoFacade() {
        super(AcaAlumno.class);
    }

    public List<AcaAlumno> obtenerPorId(String id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AcaAlumno> criteriaQuery = cb.createQuery(AcaAlumno.class);
        Root<AcaAlumno> fromAlumno = criteriaQuery.from(AcaAlumno.class);
        Predicate pId = cb.equal(fromAlumno.get("alnIdentificacion"), id);
        criteriaQuery.select(fromAlumno).where(pId);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public List<AcaAlumno> obtenerPorNombre(String nombre) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AcaAlumno> criteriaQuery = cb.createQuery(AcaAlumno.class);
        Root<AcaAlumno> fromAlumno = criteriaQuery.from(AcaAlumno.class);
        Predicate pId = cb.equal(fromAlumno.get("alnNombre"), nombre);
        criteriaQuery.select(fromAlumno).where(pId);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public List<AcaAlumno> obtenerPorApellido(String apellido) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AcaAlumno> criteriaQuery = cb.createQuery(AcaAlumno.class);
        Root<AcaAlumno> fromAlumno = criteriaQuery.from(AcaAlumno.class);
        Predicate pId = cb.equal(fromAlumno.get("alnApellido"), apellido);
        criteriaQuery.select(fromAlumno).where(pId);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public List<AcaAlumno> obtenerPorTodosParametros(String id, String nombre, String apellido) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AcaAlumno> criteriaQuery = cb.createQuery(AcaAlumno.class);
        Root<AcaAlumno> fromAlumno = criteriaQuery.from(AcaAlumno.class);
        criteriaQuery.select(fromAlumno);
        
        List<Predicate> criterios = new ArrayList<>();
        
        criterios.add(cb.equal(fromAlumno.get("alnIdentificacion"), cb.parameter(String.class, "alnIdentificacion")));
        criterios.add(cb.equal(fromAlumno.get("alnNombre"), cb.parameter(String.class, "alnNombre")));
        criterios.add(cb.equal(fromAlumno.get("alnApellido"), cb.parameter(String.class, "alnApellido")));
        
        criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        
        TypedQuery<AcaAlumno> query = em.createQuery(criteriaQuery);
        query.setParameter("alnIdentificacion", id);
        query.setParameter("alnNombre", nombre);
        query.setParameter("alnApellido", apellido);
        
        return query.getResultList();
    }

}
