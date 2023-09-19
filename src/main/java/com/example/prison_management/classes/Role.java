package com.example.prison_management.classes;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@javax.persistence.Access(AccessType.PROPERTY)
public class Role {

    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    String name;
    String fathersName;
    String GrandFathersName;
    Sex sex = Sex.NOT_SPECIFIED;
    int age;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Lob
    private byte[] image;

    public Role(String name, String fathersName, String grandFathersName, Sex sex, int age) {
        this.name = name;
        this.fathersName = fathersName;
        this.GrandFathersName = grandFathersName;
        this.sex = sex;
        this.age = age;
    }
    public Role(){}


    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    @Column
    public String getGrandFathersName() {
        return GrandFathersName;
    }

    public void setGrandFathersName(String grandFathersName) {
        GrandFathersName = grandFathersName;
    }

    @Column
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Column
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column
    public void setId(Long id) {
        this.id = id;
    }
}
