package com.dev.student_management.repo;

import com.dev.student_management.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {
}
