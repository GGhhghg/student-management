package com.dev.student_management.dto;

import lombok.Data;

@Data
public class CourseUpdateDTO {

    private int courseId;

    private String courseName;

    private String syllabus;

    private String duration;

    public CourseUpdateDTO() {
    }

    public CourseUpdateDTO(int courseId, String courseName, String syllabus, String duration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.syllabus = syllabus;
        this.duration = duration;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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
