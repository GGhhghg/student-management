package com.dev.student_management.dto;

import lombok.*;
import com.dev.student_management.entity.Course;


@Data
public class BatchDTO {

    private int batchId;

    private String batchName;

    private Course course;

    private String startDate;

    public BatchDTO() {
    }

    public BatchDTO(int batchId, String batchName, Course course, String startDate) {
        this.batchId = batchId;
        this.batchName = batchName;
        this.course = course;
        this.startDate = startDate;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
