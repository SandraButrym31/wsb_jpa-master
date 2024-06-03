package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VisitServiceImpl implements VisitService
{
    private final VisitDao visitDaoImpl;

    @Autowired
    public VisitServiceImpl(VisitDao pVisitDaoImpl)
    {
        visitDaoImpl = pVisitDaoImpl;
    }

    @Override
    public VisitTO findById(Long id) {
        final VisitEntity entity = visitDaoImpl.findOne(id);
        return VisitMapper.mapToTO(entity);
    }
}