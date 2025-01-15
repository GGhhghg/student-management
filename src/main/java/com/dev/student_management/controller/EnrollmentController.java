package com.dev.student_management.controller;

import com.dev.student_management.dto.*;
import com.dev.student_management.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping(path = "/save")
    public String saveEnrollment(@RequestBody EnrollmentSaveDTO enrollmentSaveDTO){
        String enrollmentName = enrollmentService.addEnrollment(enrollmentSaveDTO);
        return enrollmentName;
    }

    @GetMapping("/getAllEnrollments")
    public List<EnrollmentDTO> getAllEnrollments(){
        List<EnrollmentDTO> allEnrollments = enrollmentService.getAllEnrollments();
        return allEnrollments;
    }

    @PostMapping("/update")
    public String updateEnrollment(@RequestBody EnrollmentUpdateDTO enrollmentUpdateDTO){
        String enrollmentName = enrollmentService.updateEnrollment(enrollmentUpdateDTO);
        return "Enrolment Updated Successfully";
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteEnrollment(@PathVariable(value="id")int id){
        boolean delete = enrollmentService.deleteEnrollment(id);
        return "Enrollment Deleted Successfully";
    }
}
