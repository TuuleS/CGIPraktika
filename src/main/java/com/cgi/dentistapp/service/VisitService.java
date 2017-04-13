package com.cgi.dentistapp.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.dentistapp.dao.VisitDao;
import com.cgi.dentistapp.dao.entity.VisitEntity;

@Service
@Transactional
public class VisitService {

    @Autowired
    private VisitDao visitDao;

    public void addVisit(String dentistName, Date dentistVisitTime, String gpName, Date gpVisitTime) {
        VisitEntity visit = new VisitEntity(dentistName, dentistVisitTime, gpName, gpVisitTime);
        visitDao.create(visit);
    }

    public List<VisitEntity> listVisits () {
        return visitDao.getAllVisits();
    }

}
