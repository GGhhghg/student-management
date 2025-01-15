package com.dev.student_management.controller;

import com.dev.student_management.dto.*;
import com.dev.student_management.service.EnrollmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Operation(summary = "Adauga o inrolare")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @PostMapping(path = "/save")
    public String saveEnrollment(@RequestBody EnrollmentSaveDTO enrollmentSaveDTO){
        String enrollmentName = enrollmentService.addEnrollment(enrollmentSaveDTO);
        return enrollmentName;
    }

    @Operation(summary = "Retrage toate inrolarile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @GetMapping("/getAllEnrollments")
    public List<EnrollmentDTO> getAllEnrollments(){
        List<EnrollmentDTO> allEnrollments = enrollmentService.getAllEnrollments();
        return allEnrollments;
    }

    @Operation(summary = "Editeaza o inrolare")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @PostMapping("/update")
    public String updateEnrollment(@RequestBody EnrollmentUpdateDTO enrollmentUpdateDTO){
        String enrollmentName = enrollmentService.updateEnrollment(enrollmentUpdateDTO);
        return "Enrolment Updated Successfully";
    }

    @Operation(summary = "Sterge o inrolare")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @DeleteMapping(path = "/delete/{id}")
    public String deleteEnrollment(@PathVariable(value="id")int id){
        boolean delete = enrollmentService.deleteEnrollment(id);
        return "Enrollment Deleted Successfully";
    }
}
