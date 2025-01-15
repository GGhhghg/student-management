package com.dev.student_management.dto;

import lombok.Data;

@Data
public class StudentUpdateDTO {
    private int studentId;

    private String studentName;

    private String address;

    private String phoneNumber;

    public StudentUpdateDTO() {
    }

    public StudentUpdateDTO(int studentId, String studentName, String address, String phoneNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
