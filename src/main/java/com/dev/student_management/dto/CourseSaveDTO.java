package com.dev.student_management.dto;

import lombok.Data;

@Data
public class CourseSaveDTO {

    private String courseName;

    private String syllabus;

    private String duration;

    public CourseSaveDTO() {
    }

    public CourseSaveDTO(String courseName, String syllabus, String duration) {
        this.courseName = courseName;
        this.syllabus = syllabus;
        this.duration = duration;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
