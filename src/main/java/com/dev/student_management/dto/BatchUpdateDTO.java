package com.dev.student_management.dto;

import lombok.*;


@Data
public class BatchUpdateDTO {
    private int batchId;

    private String batchName;

    private int courseId;

    private String startDate;

    public BatchUpdateDTO() {
    }

    public BatchUpdateDTO(int batchId, String batchName, int courseId, String startDate) {
        this.batchId = batchId;
        this.batchName = batchName;
        this.courseId = courseId;
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

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
