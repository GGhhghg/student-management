package com.dev.student_management.dto;

import com.dev.student_management.entity.Course;
import lombok.*;


@Data
public class BatchSaveDTO {
    private String batchName;

    private int courseId;

    private String startDate;

    public BatchSaveDTO() {
    }

    public BatchSaveDTO(String batchName, int courseId, String startDate) {
        this.batchName = batchName;
        this.courseId = courseId;
        this.startDate = startDate;
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
