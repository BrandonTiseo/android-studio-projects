package com.example.assignment04;

import java.io.Serializable;

public class Student implements Serializable {
    String name;
    String email;
    String studentID;
    String department;

    int avatar;

    public Student(String name, String email, String studentID, String department, int avatar) {
        this.name = name;
        this.email = email;
        this.studentID = studentID;
        this.department = department;
        this.avatar = avatar;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
