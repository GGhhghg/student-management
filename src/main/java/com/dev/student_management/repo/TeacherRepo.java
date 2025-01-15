package com.dev.student_management.repo;

import com.dev.student_management.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
}
