package com.cgi.dentistapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cgi.dentistapp.dao.entity.VisitEntity;

import java.util.List;

@Repository
public class VisitDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(VisitEntity visit) {
        entityManager.persist(visit);
    }

    public List<VisitEntity> getAllVisits() {
        return entityManager.createQuery("SELECT e FROM VisitEntity e").getResultList();
    }
}
