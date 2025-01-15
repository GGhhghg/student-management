package com.dev.student_management.service;

import com.dev.student_management.dto.EnrollmentDTO;
import com.dev.student_management.dto.EnrollmentSaveDTO;
import com.dev.student_management.dto.EnrollmentUpdateDTO;

import java.util.List;

public interface EnrollmentService {
    String addEnrollment(EnrollmentSaveDTO enrollmentSaveDTO);

    List<EnrollmentDTO> getAllEnrollments();

    String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO);

    boolean deleteEnrollment(int id);
}
