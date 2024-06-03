package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long>{

  public List<PatientEntity> findPatientByLastName(String lastName);

  public List<PatientEntity> findPatientWithMoreThanXVisits(Long x);

  public List<VisitEntity> findVisitsById(Long id);

  public List<PatientEntity> findPatientsByLikeDescription(String description);

  public List<PatientEntity> findPatientsByActive(boolean active);
}
