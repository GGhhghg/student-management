package com.dev.student_management.controller;

import com.dev.student_management.dto.*;
import com.dev.student_management.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Operation(summary = "Aduaga curs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @PostMapping(path = "/save")
    public String saveCourse(@RequestBody CourseSaveDTO courseSaveDTO){
        String courseName = courseService.addCourse(courseSaveDTO);
        return courseName;
    }

    @Operation(summary = "Retrage toate cursurile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @GetMapping("/getAllCourses")
    public List<CourseDTO> getAllCourses(){
        List<CourseDTO> allCourses = courseService.getAllCourses();
        return allCourses;
    }

    @Operation(summary = "Modifica cursurile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @PostMapping("/update")
    public String updateCourse(@RequestBody CourseUpdateDTO courseUpdateDTO){
        String courseName = courseService.updateStudent(courseUpdateDTO);
        return "Course Updated Successfully";
    }

    @Operation(summary = "Sterge cursurile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @DeleteMapping(path = "/delete/{id}")
    public String deleteCourse(@PathVariable(value="id")int id){
        boolean delete = courseService.deleteCourse(id);
        return "Course Deleted Successfully";
    }
}
