package com.dev.student_management.controller;

import com.dev.student_management.dto.*;
import com.dev.student_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping(path = "/save")
    public String saveCourse(@RequestBody CourseSaveDTO courseSaveDTO){
        String courseName = courseService.addCourse(courseSaveDTO);
        return courseName;
    }

    @GetMapping("/getAllCourses")
    public List<CourseDTO> getAllCourses(){
        List<CourseDTO> allCourses = courseService.getAllCourses();
        return allCourses;
    }

    @PostMapping("/update")
    public String updateCourse(@RequestBody CourseUpdateDTO courseUpdateDTO){
        String courseName = courseService.updateStudent(courseUpdateDTO);
        return "Course Updated Successfully";
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteCourse(@PathVariable(value="id")int id){
        boolean delete = courseService.deleteCourse(id);
        return "Course Deleted Successfully";
    }
}
