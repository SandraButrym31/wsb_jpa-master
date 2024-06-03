package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;

public class DoctorMapper {

  public static DoctorTO mapToTO(final DoctorEntity doctorEntity) {
    if (doctorEntity == null)
    {
      return null;
    }
    final DoctorTO doctorTO = new DoctorTO();
    doctorTO.setId(doctorEntity.getId());
    doctorTO.setFirstName(doctorEntity.getFirstName());
    doctorTO.setLastName(doctorEntity.getLastName());
    doctorTO.setDoctorNumber(doctorEntity.getDoctorNumber());
    doctorTO.setAddress(doctorEntity.getAddress());
    doctorTO.setEmail(doctorEntity.getEmail());
    doctorTO.setTelephoneNumber(doctorEntity.getTelephoneNumber());
    doctorTO.setSpecialization(doctorEntity.getSpecialization());
    doctorTO.setVisits(doctorEntity.getVisits());
    return doctorTO;
  }

  public static DoctorEntity mapToEntity(final DoctorTO doctorTO) {
    if(doctorTO == null) {
      return null;
    }
    DoctorEntity doctorEntity = new DoctorEntity();
    doctorEntity.setId(doctorTO.getId());
    doctorEntity.setFirstName(doctorTO.getFirstName());
    doctorEntity.setLastName(doctorTO.getLastName());
    doctorEntity.setDoctorNumber(doctorTO.getDoctorNumber());
    doctorEntity.setAddress(doctorTO.getAddress());
    doctorEntity.setEmail(doctorTO.getEmail());
    doctorEntity.setTelephoneNumber(doctorTO.getTelephoneNumber());
    doctorEntity.setSpecialization(doctorTO.getSpecialization());
    doctorEntity.setVisits(doctorTO.getVisits());
    return doctorEntity;
  }
}
