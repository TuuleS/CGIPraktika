package com.cgi.dentistapp.dto;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by tuules on 13/04/2017.
 */
public class SearchResultDTO {

    @Size(min = 2, max = 100)
    private String dentistName;

    @Size(min = 2, max = 100)
    private String gpName;

    private Date dentistVisitTime;

    private Date gpVisitTime;

    public SearchResultDTO() {
    }

    public SearchResultDTO(String dentistName, String gpName, Date dentistVisitTime, Date gpVisitTime) {
        this.dentistName = dentistName;
        this.gpName = gpName;
        this.dentistVisitTime = dentistVisitTime;
        this.gpVisitTime = gpVisitTime;
    }

    public String getDentistName() {
        return dentistName;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    public Date getDentistVisitTime() {
        return dentistVisitTime;
    }

    public void setDentistVisitTime(Date dentistVisitTime) {
        this.dentistVisitTime = dentistVisitTime;
    }

    public Date getGpVisitTime() {
        return gpVisitTime;
    }

    public void setGpVisitTime(Date gpVisitTime) {
        this.gpVisitTime = gpVisitTime;
    }
}
