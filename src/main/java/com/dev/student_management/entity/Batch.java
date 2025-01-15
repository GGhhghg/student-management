package com.dev.student_management.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "batch")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_id", length = 11)
    private int batchId;

    @Column(name = "batch_name", length = 50)
    private String batchName;

    @Column(name = "start_date")
    private String startDate;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "batch")
    private List<Enrollment> enrollments;


    public Batch(){}

    public Batch(int batchId, String batchName, String startDate, Course course) {
        this.batchId = batchId;
        this.batchName = batchName;
        this.startDate = startDate;
        this.course = course;
    }

    public Batch(String batchName, String startDate, Course course) {
        this.batchName = batchName;
        this.startDate = startDate;
        this.course = course;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "batchId=" + batchId +
                ", batchName='" + batchName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", course=" + course +
                '}';
    }
}
