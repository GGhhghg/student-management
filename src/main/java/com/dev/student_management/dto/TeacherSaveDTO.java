package com.dev.student_management.dto;

import lombok.*;

@Data
public class TeacherSaveDTO {

    private String teacherName;

    private String address;

    private String phoneNumber;

    public TeacherSaveDTO() {}

    public TeacherSaveDTO(String teacherName, String address, String phoneNumber) {
        this.teacherName = teacherName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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
