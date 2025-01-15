package com.dev.student_management.service;

import com.dev.student_management.dto.StudentDTO;
import com.dev.student_management.dto.StudentSaveDTO;
import com.dev.student_management.dto.StudentUpdateDTO;

import java.util.List;

public interface StudentService {
    String addStudent(StudentSaveDTO studentSaveDTO);

    List<StudentDTO> getAllStudents();

    String updateStudent(StudentUpdateDTO studentUpdateDTO);

    boolean deleteStudent(int id);
}
