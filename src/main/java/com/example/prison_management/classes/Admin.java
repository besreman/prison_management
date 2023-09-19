package com.example.prison_management.classes;

import java.time.Duration;
import java.util.Date;

public class Admin extends Role {
    String title;

    public Admin(String title, String name, String fName, String gFName, int age, Sex sex) {
        super(name,fName, gFName,sex,age);
        this.title = title;
    }

    void RegisterPolice(Gard gard){

    }

    void addPrisoner(Prisoner prisoner){

    }

    void removePrisoner(Prisoner prisoner){

    }

    boolean setCurrentGard(Gard gard){
        return false;
    }

    }
