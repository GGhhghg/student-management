package com.dev.student_management.dto;

import com.dev.student_management.entity.Batch;
import com.dev.student_management.entity.Student;
import lombok.Data;

@Data
public class EnrollmentDTO {

    private int enrollmentId;

    private Student student;

    private Batch batch;

    private String joinDate;

    private int fee;

    public EnrollmentDTO() {
    }

    public EnrollmentDTO(int enrollmentId, Student student, Batch batch, String joinDate, int fee) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.batch = batch;
        this.joinDate = joinDate;
        this.fee = fee;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
