package com.dev.student_management.service;

import com.dev.student_management.dto.BatchDTO;
import com.dev.student_management.dto.BatchSaveDTO;
import com.dev.student_management.dto.BatchUpdateDTO;

import java.util.List;

public interface BatchService {
    String addBatch(BatchSaveDTO batchSaveDTO);

    List<BatchDTO> getAllBatches();

    String updateBatch(BatchUpdateDTO batchUpdateDTO);

    boolean deleteCourse(int id);
}
