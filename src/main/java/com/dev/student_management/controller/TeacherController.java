package com.dev.student_management.controller;

import com.dev.student_management.dto.*;
import com.dev.student_management.service.StudentService;
import com.dev.student_management.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Operation(summary="Adauga profesori in baza de date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @PostMapping(path="save")
    public String saveTeacher(@RequestBody TeacherSaveDTO teacherSaveDTO){
        String teacherName = teacherService.addTeacher(teacherSaveDTO);
        return teacherName;
    }

    @Operation(summary = "Retrage toti profesorii din bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @GetMapping(path = "/getAllTeachers")
    public List<TeacherDTO> getAllTeachers() {
        List<TeacherDTO> allTeachers = teacherService.getAllTeachers();
        return allTeachers;
    }

    @Operation(summary = "Editeaza profesori deja existenti")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @PostMapping("/update")
    public String updateTeacher(@RequestBody TeacherUpdateDTO teacherUpdateDTO){
        String teacherName = teacherService.updateTeacher(teacherUpdateDTO);
        return "Teacher Updated Successfully";
    }

    @Operation(summary = "Sterge profesori")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @DeleteMapping(path = "/delete/{id}")
    public String deleteTeacher(@PathVariable(value="id")int id){
        boolean delete = teacherService.deleteTeacher(id);
        return "Teacher Deleted Successfully";
    }
}
