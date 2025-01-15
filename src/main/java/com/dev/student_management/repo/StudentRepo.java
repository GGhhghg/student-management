package com.dev.student_management.repo;

import com.dev.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
