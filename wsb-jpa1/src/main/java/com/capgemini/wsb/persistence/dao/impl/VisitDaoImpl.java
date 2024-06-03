package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class VisitDaoImpl  extends AbstractDao<VisitEntity, Long> implements VisitDao {

  @Override
  public List<VisitTO> findAllByPatientId(Long patientId) {
    return entityManager.createQuery(
            "SELECT v FROM VisitEntity v WHERE v.patientEntity.id = :patientId", VisitTO.class)
        .setParameter("patientId", patientId)
        .getResultList();
  }
}