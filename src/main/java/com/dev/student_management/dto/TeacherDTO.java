package com.dev.student_management.dto;

import lombok.*;


@Data
public class TeacherDTO {

    private int teacherId;

    private String teacherName;

    private String address;

    private String phoneNumber;

    public TeacherDTO() {
    }

    public TeacherDTO(int teacherId, String teacherName, String address, String phoneNumber) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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
