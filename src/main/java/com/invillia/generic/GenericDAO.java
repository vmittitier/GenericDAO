package com.invillia.generic;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class GenericDAO<T> {
    private final EntityManager entityManager;
    private final Class<T> clazz;

    public GenericDAO(EntityManager entityManager, Class<T> clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }

    public List<T> findAll() {
        final String hql = "from " + clazz.getSimpleName();
        final TypedQuery<T> query = entityManager.createQuery(hql, clazz);
        return query.getResultList();
    }

    public T findById(final long id) {
        return entityManager.find(clazz, id);
    }

    public void insert(final T entity) {
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    public void update(final T entity) {
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(entity);
        transaction.commit();
    }

    public void deleteById(final long id) {
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        final T entity = findById(id);
        entityManager.remove(entity);
        transaction.commit();
    }



}
