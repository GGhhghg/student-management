package com.dev.student_management.service;

import com.dev.student_management.dto.CourseDTO;
import com.dev.student_management.dto.CourseSaveDTO;
import com.dev.student_management.dto.CourseUpdateDTO;

import java.util.List;

public interface CourseService {
    String addCourse(CourseSaveDTO courseSaveDTO);

    List<CourseDTO> getAllCourses();

    String updateStudent(CourseUpdateDTO courseUpdateDTO);

    boolean deleteCourse(int id);
}
