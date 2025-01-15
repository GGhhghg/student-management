package com.dev.student_management.repo;

import com.dev.student_management.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<Enrollment, Integer> {
}
