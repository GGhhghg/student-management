package com.dev.student_management.controller;

import com.dev.student_management.dto.*;
import com.dev.student_management.service.StudentService;
import com.dev.student_management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping(path="save")
    public String saveTeacher(@RequestBody TeacherSaveDTO teacherSaveDTO){
        String teacherName = teacherService.addTeacher(teacherSaveDTO);
        return teacherName;
    }

    @GetMapping(path = "/getAllTeachers")
    public List<TeacherDTO> getAllTeachers() {
        List<TeacherDTO> allTeachers = teacherService.getAllTeachers();
        return allTeachers;
    }

    @PostMapping("/update")
    public String updateTeacher(@RequestBody TeacherUpdateDTO teacherUpdateDTO){
        String teacherName = teacherService.updateTeacher(teacherUpdateDTO);
        return "Teacher Updated Successfully";
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteTeacher(@PathVariable(value="id")int id){
        boolean delete = teacherService.deleteTeacher(id);
        return "Teacher Deleted Successfully";
    }
}
