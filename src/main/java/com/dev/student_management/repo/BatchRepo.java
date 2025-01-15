package com.dev.student_management.repo;

import com.dev.student_management.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepo extends JpaRepository<Batch, Integer> {
}
