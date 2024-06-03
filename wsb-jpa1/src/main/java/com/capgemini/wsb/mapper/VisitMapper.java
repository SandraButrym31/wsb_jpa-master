package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public final class VisitMapper
{
    public static VisitTO mapToTO(final VisitEntity visitEntity)
    {
        if (visitEntity == null)
        {
            return null;
        }
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDoctor(visitEntity.getDoctor());
        visitTO.setPatient(visitEntity.getPatient());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setMedicalTreatments(visitEntity.getMedicalTreatmentEntityList());
        visitTO.setTime(visitEntity.getTime());
        return visitTO;
    }

    public static VisitEntity mapToEntity(final VisitTO visitTO)
    {
        if (visitTO == null)
        {
            return null;
        }
        final VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDoctor(visitTO.getDoctor());
        visitEntity.setPatient(visitTO.getPatient());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setMedicalTreatmentEntityList(visitTO.getMedicalTreatments());
        visitEntity.setTime(visitTO.getTime());
        return visitEntity;
    }

}