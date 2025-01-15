package com.dev.student_management.service.impl;

import com.dev.student_management.dto.CourseDTO;
import com.dev.student_management.dto.CourseSaveDTO;
import com.dev.student_management.dto.CourseUpdateDTO;
import com.dev.student_management.entity.Course;
import com.dev.student_management.repo.CourseRepo;
import com.dev.student_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceIMPL implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    public CourseServiceIMPL(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public String addCourse(CourseSaveDTO courseSaveDTO) {
        Course course = new Course(
                courseSaveDTO.getCourseName(),
                courseSaveDTO.getSyllabus(),
                courseSaveDTO.getDuration()
        );
        courseRepo.save(course);
        return course.getCourseName() + " adaugat cu success!";
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> getCourses = courseRepo.findAll();
        List<CourseDTO> courseDTOList = new ArrayList<>();

        for(Course course : getCourses){
            CourseDTO courseDTO = new CourseDTO(
                    course.getCourseId(),
                    course.getCourseName(),
                    course.getSyllabus(),
                    course.getDuration()
            );
            courseDTOList.add(courseDTO);
        }

        return courseDTOList;
    }

    @Override
    public String updateStudent(CourseUpdateDTO courseUpdateDTO) {
        if(courseRepo.existsById(courseUpdateDTO.getCourseId())){
            Course course = courseRepo.getById(courseUpdateDTO.getCourseId());
            course.setCourseName(courseUpdateDTO.getCourseName());
            course.setSyllabus(courseUpdateDTO.getSyllabus());
            course.setDuration(courseUpdateDTO.getDuration());
            courseRepo.save(course);
            return course.getCourseName();

        } else {
            System.out.println("Course not found");
        }

        return null;
    }

    @Override
    public boolean deleteCourse(int id) {
        if(courseRepo.existsById(id)){
            courseRepo.deleteById(id);
        } else {
            System.out.println("Course not found");
        }

        return false;
    }
}
