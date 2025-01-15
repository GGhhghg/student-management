package com.dev.student_management.controller;

import com.dev.student_management.dto.StudentDTO;
import com.dev.student_management.dto.StudentSaveDTO;
import com.dev.student_management.dto.StudentUpdateDTO;
import com.dev.student_management.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Adaua un student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @PostMapping(path = "/save")
    public String saveStudent(@RequestBody StudentSaveDTO studentSaveDTO){
        String studentName = studentService.addStudent(studentSaveDTO);
        return studentName;
    }

    @Operation(summary = "Retrage toti studentii")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @GetMapping("/getAllStudents")
    public List<StudentDTO> getAllStudents(){
        List<StudentDTO> allStudents = studentService.getAllStudents();
        return allStudents;
    }

    @Operation(summary = "Editeaza un student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @PostMapping("/update")
    public String updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO){
        String studentName = studentService.updateStudent(studentUpdateDTO);
        return "Student Updated Successfully";
    }

    @Operation(summary = "Sterge un student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @DeleteMapping(path = "/delete/{id}")
    public String deleteStudent(@PathVariable(value="id")int id){
        boolean delete = studentService.deleteStudent(id);
        return "Student Deleted Successfully";
    }

}
