package com.dev.student_management.service.impl;

import com.dev.student_management.dto.BatchDTO;
import com.dev.student_management.dto.BatchSaveDTO;
import com.dev.student_management.dto.BatchUpdateDTO;
import com.dev.student_management.entity.Batch;
import com.dev.student_management.repo.BatchRepo;
import com.dev.student_management.repo.CourseRepo;
import com.dev.student_management.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BatchServiceIMPL implements BatchService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private BatchRepo batchRepo;

    @Override
    public String addBatch(BatchSaveDTO batchSaveDTO) {

        Batch batch = new Batch(
                batchSaveDTO.getBatchName(),
                batchSaveDTO.getStartDate(),
                courseRepo.getById(batchSaveDTO.getCourseId())
        );
        batchRepo.save(batch);
        return batch.getBatchName()  + " adaugat cu success!";
    }

    @Override
    public List<BatchDTO> getAllBatches() {
        List<Batch> getBatches = batchRepo.findAll();
        List<BatchDTO> batchDTOList = new ArrayList<>();
        
        for(Batch batch : getBatches){
            BatchDTO batchDTO = new BatchDTO(
                    batch.getBatchId(),
                    batch.getBatchName(),
                    batch.getCourse(),
                    batch.getStartDate()
            );
            batchDTOList.add(batchDTO);
        }

        return batchDTOList;
    }

    @Override
    public String updateBatch(BatchUpdateDTO batchUpdateDTO) {
        if(batchRepo.existsById(batchUpdateDTO.getBatchId())){
            Batch batch = batchRepo.getById(batchUpdateDTO.getBatchId());
            batch.setBatchName(batchUpdateDTO.getBatchName());
            batch.setCourse(courseRepo.getById(batchUpdateDTO.getCourseId()));
            batch.setStartDate(batchUpdateDTO.getStartDate());

            batchRepo.save(batch);
            return batch.getBatchName();
        } else {
            System.out.println("Batch not found");
        }
        return null;
    }

    @Override
    public boolean deleteCourse(int id) {
        if(batchRepo.existsById(id)){
            batchRepo.deleteById(id);
        } else {
            System.out.println("Batch not found");
        }

        return false;
    }
}
