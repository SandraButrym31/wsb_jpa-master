package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;

public interface DoctorDao extends Dao<DoctorEntity, Long> {
  public DoctorTO findById(Long id);
}