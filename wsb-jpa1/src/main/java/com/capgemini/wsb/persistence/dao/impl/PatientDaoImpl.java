package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
    @Override
    @Transactional
    public List<PatientEntity> findPatientByLastName(String lastName) {
        String hql = "FROM PatientEntity p WHERE p.lastName = :lastName";
        TypedQuery<PatientEntity> query = entityManager.createQuery(hql, PatientEntity.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<PatientEntity> findPatientWithMoreThanXVisits(Long x) {
        String hql = "SELECT p FROM PatientEntity p " +
            "JOIN VisitEntity v ON p.id = v.patient.id " +
            "GROUP BY p.id " +
            "HAVING COUNT(v.id) > :visitCount";
        TypedQuery<PatientEntity> query = entityManager.createQuery(hql, PatientEntity.class);
        query.setParameter("visitCount", (long) x);
        return query. getResultList();
    }

    @Override
    public List<VisitEntity> findVisitsById(Long id) {
        String hql = "SELECT v FROM VisitEntity v WHERE v.patient.id = :patientId";
        TypedQuery<VisitEntity> query = entityManager.createQuery(hql, VisitEntity.class);
        query.setParameter("patientId", id);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsByLikeDescription(String description) {
        String hql = "SELECT p FROM PatientEntity p WHERE p.description LIKE :description";
        TypedQuery<PatientEntity> query = entityManager.createQuery(hql, PatientEntity.class);
        query.setParameter("description", "%" + description + "%");
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsByActive(boolean active) {
        String hql = "SELECT p FROM PatientEntity p WHERE p.active = :active";
        TypedQuery<PatientEntity> query = entityManager.createQuery(hql, PatientEntity.class);
        query.setParameter("active", active);
        return query.getResultList();
    }

}