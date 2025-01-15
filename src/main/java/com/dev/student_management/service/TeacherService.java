package com.dev.student_management.service;

import com.dev.student_management.dto.TeacherDTO;
import com.dev.student_management.dto.TeacherSaveDTO;
import com.dev.student_management.dto.TeacherUpdateDTO;

import java.util.List;

public interface TeacherService {
    String addTeacher(TeacherSaveDTO teacherSaveDTO);

    List<TeacherDTO> getAllTeachers();

    String updateTeacher(TeacherUpdateDTO teacherUpdateDTO);

    boolean deleteTeacher(int id);
}
