package com.dev.student_management.service.impl;

import com.dev.student_management.dto.EnrollmentDTO;
import com.dev.student_management.dto.EnrollmentSaveDTO;
import com.dev.student_management.dto.EnrollmentUpdateDTO;
import com.dev.student_management.entity.Enrollment;
import com.dev.student_management.repo.BatchRepo;
import com.dev.student_management.repo.EnrollmentRepo;
import com.dev.student_management.repo.StudentRepo;
import com.dev.student_management.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentServiceIMPL implements EnrollmentService {

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private BatchRepo batchRepo;


    @Override
    public String addEnrollment(EnrollmentSaveDTO enrollmentSaveDTO) {
        Enrollment enrollment = new Enrollment(
                studentRepo.getById(enrollmentSaveDTO.getStudentId()),
                batchRepo.getById(enrollmentSaveDTO.getBatchId()),
                enrollmentSaveDTO.getJoinDate(),
                enrollmentSaveDTO.getFee()
        );
        enrollmentRepo.save(enrollment);

        return "Inrolare facuta cu succes in data de " + enrollment.getJoinDate();
    }

    @Override
    public List<EnrollmentDTO> getAllEnrollments() {
        List<Enrollment> getEnrollments = enrollmentRepo.findAll();
        List<EnrollmentDTO> enrollmentDTOList = new ArrayList<>();

        for(Enrollment enrollment : getEnrollments){
            EnrollmentDTO enrollmentDTO = new EnrollmentDTO(
                    enrollment.getEnrollmentId(),
                    enrollment.getStudent(),
                    enrollment.getBatch(),
                    enrollment.getJoinDate(),
                    enrollment.getFee()
            );
            enrollmentDTOList.add(enrollmentDTO);
        }
        return enrollmentDTOList;
    }

    @Override
    public String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO) {
        if(enrollmentRepo.existsById(enrollmentUpdateDTO.getEnrollmentId())){
            Enrollment enrollment = enrollmentRepo.getById(enrollmentUpdateDTO.getEnrollmentId());
            enrollment.setStudent(studentRepo.getById(enrollmentUpdateDTO.getStudentId()));
            enrollment.setBatch(batchRepo.getById(enrollmentUpdateDTO.getBatchId()));
            enrollment.setJoinDate(enrollmentUpdateDTO.getJoinDate());
            enrollment.setFee(enrollmentUpdateDTO.getFee());
            enrollmentRepo.save(enrollment);
            return "Enrollment updated successfully on " + enrollment.getJoinDate();
        } else {
            System.out.println("Enrollment not found");
        }

        return null;
    }

    @Override
    public boolean deleteEnrollment(int id) {
        if(enrollmentRepo.existsById(id)){
            enrollmentRepo.deleteById(id);
        } else {
            System.out.println("Enrollment not found");
        }

        return false;
    }
}
