package com.cgi.dentistapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.cgi.dentistapp.dto.SearchQueryDTO;
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

    public List<VisitEntity> listVisits() {
        return visitDao.getAllVisits();
    }

    public List<VisitEntity> listVisits(SearchQueryDTO query) {
        List<VisitEntity> allres = visitDao.getAllVisits();
        List<VisitEntity> actualres = new ArrayList<>();

        for (VisitEntity res : allres) {

            int lev1 = distance(res.getDentistName().toLowerCase(), query.getDentistName().toLowerCase());
            int lev2 = distance(res.getGpName().toLowerCase(), query.getDentistName().toLowerCase());

            if (lev1 <= 4 || lev2 <= 4) {
                actualres.add(res);
            }
        }
        return actualres;
    }

    /**
     * Calculates the Levenshtein distance between two strings. If it's small enough, they are similar.
     * Code taken from https://rosettacode.org/wiki/Levenshtein_distance#Java
     *
     * @param a - the first string to be compared
     * @param b - the second string to be compared
     * @return integer - how many steps it takes to change a into b
     */
    private static int distance(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        // i == 0
        int[] costs = new int[b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            // j == 0; nw = lev(i - 1, j)
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }
}
