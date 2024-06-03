package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

public interface PatientService {
    public PatientTO findById(final Long id);
    public boolean removePatient(final Long id);
    public List<PatientTO> findByLastName(final String lastName);
    public List<VisitTO> findVisitsByPatientId(final Long patientId);
    List<PatientTO> findPatientsWithMoreThanCountOfVisits(Long countOfVisits);
    List<PatientTO> findPatientsByActive(boolean active);
    List<PatientTO> findPatientsByLikeDescription(String description);
    public List<VisitTO> findAllVisit(final Long id);

    public PatientTO save(PatientTO patientTO);
}