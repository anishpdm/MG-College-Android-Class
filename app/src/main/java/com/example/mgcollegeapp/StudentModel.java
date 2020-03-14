package com.example.mgcollegeapp;

public class StudentModel {

    public String name;
    public String rollno;
    public String admno;
    public String college;
    public String ProfilePic;

    public StudentModel() {
    }

    public StudentModel(String name, String rollno, String admno, String college, String profilePic) {
        this.name = name;
        this.rollno = rollno;
        this.admno = admno;
        this.college = college;
        this.ProfilePic = profilePic;
    }


}