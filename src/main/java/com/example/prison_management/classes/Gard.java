package com.example.prison_management.classes;

public class Gard extends Role {
    String title;

    public Gard(String title, String name, String fName, String gFName, int age, Sex sex) {

        super(name,fName, gFName,sex,age);
        this.title = title;
    }

    static boolean SendReport(){
        return false;
    }
}
