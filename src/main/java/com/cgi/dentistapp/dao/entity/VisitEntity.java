package com.cgi.dentistapp.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "visit")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "dentist_visit_time")
    private Date dentistVisitTime;

    @Column(name = "dentist_name")
    private String dentistName;

    @Column(name = "gp_name")
    private String gpName;

    @Column(name = "gp_visit_time")
    private Date gpVisitTime;


    public VisitEntity() {
    }

    public VisitEntity(String dentistName, Date dentistVisitTime, String gpName, Date gpVisitTime) {
        this.dentistVisitTime = dentistVisitTime;
        this.dentistName = dentistName;
        this.gpName = gpName;
        this.gpVisitTime = gpVisitTime;
    }

    public VisitEntity(String dentistName, Date dentistVisitTime) {
        this.setDentistVisitTime(dentistVisitTime);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDentistVisitTime() {
        return dentistVisitTime;
    }

    public void setDentistVisitTime(Date dentistVisitTime) {
        this.dentistVisitTime = dentistVisitTime;
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

    public Date getGpVisitTime() {
        return gpVisitTime;
    }

    public void setGpVisitTime(Date gpVisitTime) {
        this.gpVisitTime = gpVisitTime;
    }

    @Override
    public String toString() {
        return "VisitEntity{" +
                "id=" + id +
                ", dentistVisitTime=" + dentistVisitTime +
                ", dentistName='" + dentistName + '\'' +
                ", gpName='" + gpName + '\'' +
                ", gpVisitTime=" + gpVisitTime +
                '}';
    }
}
