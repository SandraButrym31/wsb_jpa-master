package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.dao.impl.PatientDaoImpl;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.PatientService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService
{
    private final PatientDao patientDao;
    private final VisitDao visitDao;

    @Autowired
    public PatientServiceImpl(PatientDao pPatientDao, VisitDao pVisitDao)
    {
        patientDao = pPatientDao;
        visitDao = pVisitDao;
    }

    @Override
    public PatientTO findById(Long id) {
        final PatientEntity entity = patientDao.findOne(id);
        return PatientMapper.mapToTO(entity);
    }

    @Override
    public boolean removePatient(Long id) {
        patientDao.delete(id);
        return true;
    }

    @Override
    public List<PatientTO> findByLastName(String lastName) {
        final List<PatientEntity> entities = patientDao.findPatientByLastName(lastName);
        List<PatientTO> result = new ArrayList<>();

        for (PatientEntity entity : entities) {
            PatientTO patientTO = PatientMapper.mapToTO(entity);
            result.add(patientTO);
        }

        return result;
    }

    @Override
    public List<VisitTO> findVisitsByPatientId(Long patientId)
    {
        final List<VisitEntity> entities = patientDao.findVisitsById(patientId);
        List<VisitTO> result = new LinkedList<>();

        for (VisitEntity entity : entities) {
            VisitTO visitTO = VisitMapper.mapToTO(entity);
            result.add(visitTO);
        }

        return result;
    }

    @Override
    public List<PatientTO> findPatientsWithMoreThanCountOfVisits(Long countOfVisits) {
        final List<PatientEntity> entities = patientDao.findPatientWithMoreThanXVisits(countOfVisits);
        List<PatientTO> result = new ArrayList<>();

        for (PatientEntity entity : entities) {
            PatientTO patientTO = PatientMapper.mapToTO(entity);
            result.add(patientTO);
        }

        return result;
    }

    @Override
    public List<PatientTO> findPatientsByActive(boolean active) {
        final List<PatientEntity> entities = patientDao.findPatientsByActive(active);
        List<PatientTO> result = new ArrayList<>();

        for (PatientEntity entity : entities) {
            PatientTO patientTO = PatientMapper.mapToTO(entity);
            result.add(patientTO);
        }

        return result;
    }

    @Override
    public List<PatientTO> findPatientsByLikeDescription(String description) {
        final List<PatientEntity> entities = patientDao.findPatientsByLikeDescription(description);
        List<PatientTO> result = new ArrayList<>();

        for (PatientEntity entity : entities) {
            PatientTO patientTO = PatientMapper.mapToTO(entity);
            result.add(patientTO);
        }

        return result;
    }

    @Override
    public List<VisitTO> findAllVisit(Long id) {
        return visitDao.findAllByPatientId(id);
    }


    @Override
    public PatientTO save(PatientTO patientTO) {
        final PatientEntity entity = PatientMapper.mapToEntity(patientTO);
        patientDao.save(entity);
        return PatientMapper.mapToTO(entity);
    }
}