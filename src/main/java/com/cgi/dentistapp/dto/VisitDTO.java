package com.cgi.dentistapp.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by serkp on 2.03.2017.
 */
public class VisitDTO {
    @NotNull
    @Size(min = 1, max = 50)
    String dentistName;

    @NotNull
    @Size(min = 1, max = 50)
    String gpName;

    @NotNull
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    Date dentistVisitTime;

    @NotNull
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    Date gpVisitTime;

    public VisitDTO() {
    }

    public VisitDTO(String dentistName, Date dentistVisitTime) {
        this.dentistName = dentistName;
        this.dentistVisitTime = dentistVisitTime;
    }

    public VisitDTO(String dentistName, String gpName, Date dentistVisitTime, Date gpVisitTime) {
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
