package com.example.mgcollegeapp;

public class StudentModel {

public String name;
public String rollno;
public String admno;
public String college;

    public StudentModel() {
    }

    public StudentModel(String name, String rollno, String admno, String college) {
        this.name = name;
        this.rollno = rollno;
        this.admno = admno;
        this.college = college;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getAdmno() {
        return admno;
    }

    public void setAdmno(String admno) {
        this.admno = admno;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
