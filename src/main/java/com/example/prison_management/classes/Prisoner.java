package com.example.prison_management.classes;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Prisoner extends Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    Date startDate;
    Date endDate;


    public Prisoner(String name, String fName, String gFName, int age, Sex sex, Date start, Date end) {
        super(name,fName, gFName,sex,age);
        this.startDate =start;
        this.endDate = end;
    }

    public Prisoner() {}

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
