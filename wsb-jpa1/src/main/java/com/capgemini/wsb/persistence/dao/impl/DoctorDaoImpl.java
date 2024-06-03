package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.mapper.DoctorMapper;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DoctorDaoImpl extends AbstractDao<DoctorEntity, Long> implements DoctorDao {

  @Override
  @Transactional
  public DoctorTO findById(Long id) {
    String hql = "from DoctorEntity where id = :id";
    TypedQuery<DoctorEntity> query = entityManager.createQuery(hql, DoctorEntity.class);
    query.setParameter("id", id);
    DoctorEntity doctorEntity = query.getSingleResult();
    return DoctorMapper.mapToTO(doctorEntity);
  }
}