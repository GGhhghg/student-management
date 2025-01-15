package com.dev.student_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class StudentSaveDTO {

    private String studentName;

    private String address;

    private String phoneNumber;

    public StudentSaveDTO() {
    }

    public StudentSaveDTO(String studentName, String address, String phoneNumber) {
        this.studentName = studentName;
        this.address = address;
        this.phoneNumber = phoneNumber;
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
