package com.dev.student_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id", length = 11)
    private int enrollmentId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;

    @Column(name = "join_date", length = 20)
    private String joinDate;

    @Column(name = "fee", length = 15)
    private int fee;

    public Enrollment(){}

    public Enrollment(int enrollmentId, Student student, Batch batch, String joinDate, int fee) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.batch = batch;
        this.joinDate = joinDate;
        this.fee = fee;
    }

    public Enrollment(Student student, Batch batch, String joinDate, int fee) {
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

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollmentId=" + enrollmentId +
                ", student=" + student +
                ", batch=" + batch +
                ", joinDate='" + joinDate + '\'' +
                ", fee=" + fee +
                '}';
    }
}
