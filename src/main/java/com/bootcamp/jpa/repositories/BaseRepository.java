package com.bootcamp.jpa.repositories;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

public class BaseRepository<T> {

    private EntityManager em;
    private String unitPersistence;
    private EntityManagerFactory emf;
    private Class entityClass;

    public BaseRepository(String unitPersistence, Class entityClass) {
        this.unitPersistence = unitPersistence;
        emf = Persistence.createEntityManagerFactory(this.unitPersistence);
        em = emf.createEntityManager();
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(getUnitPersistence());
        setEm(emf.createEntityManager());
        return getEm();
    }

    public boolean create(T obj) throws SQLException {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        return true;
    }

    public boolean delete(T obj) throws SQLException {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        return true;
    }

    public boolean update(T obj) throws SQLException {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        return true;
    }

    public T findOneByProperty(String propertyName, Object value) throws SQLException {
        try {
            String className = getEntityClass().getSimpleName();
            String request = "select t from " + className + " t where t." + propertyName + "=:param";
            Query query = getEm().createQuery(request);
            query.setParameter("param", value);
            return (T) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<T> findEntitiesByProperty(Long propertyId, Object value) throws SQLException {
        String className = entityClass.getClass().getSimpleName();
        String query = "SELECT b FROM " + className + " b where b." +propertyId +"=:param";
        Query qry = getEm().createQuery(query);
        qry.setParameter("param", value);
        List<T> listeEntities = qry.getResultList();
        return listeEntities;
    }

    public List<T> findAll() throws SQLException {
        String className = getEntityClass().getSimpleName();
        String qlString = "SELECT b FROM " + className + " b";
        Query q = getEm().createQuery(qlString);
        List<T> listeEntities = q.getResultList();
        return listeEntities;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public String getUnitPersistence() {
        return unitPersistence;
    }

    public void setUnitPersistence(String UnitPersistence) {
        this.unitPersistence = UnitPersistence;
    }

    public Class getEntityClass() {
        return entityClass;
    }
}
