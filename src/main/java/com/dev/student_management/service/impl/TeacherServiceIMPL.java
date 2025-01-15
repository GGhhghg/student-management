package com.dev.student_management.service.impl;

import com.dev.student_management.dto.TeacherDTO;
import com.dev.student_management.dto.TeacherSaveDTO;
import com.dev.student_management.dto.TeacherUpdateDTO;
import com.dev.student_management.entity.Teacher;
import com.dev.student_management.repo.TeacherRepo;
import com.dev.student_management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceIMPL implements TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public String addTeacher(TeacherSaveDTO teacherSaveDTO) {

        Teacher teacher = new Teacher(
                teacherSaveDTO.getTeacherName(),
                teacherSaveDTO.getAddress(),
                teacherSaveDTO.getPhoneNumber()
        );

        teacherRepo.save(teacher);

        return teacher.getTeacherName() + " adaugat cu success!";
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {

        List<Teacher> getTeachers = teacherRepo.findAll();
        List<TeacherDTO> teacherDTOList = new ArrayList<>();

        for(Teacher teacher : getTeachers){
            TeacherDTO teacherDTO = new TeacherDTO(
                    teacher.getTeacherId(),
                    teacher.getTeacherName(),
                    teacher.getAddress(),
                    teacher.getPhoneNumber()
            );
            teacherDTOList.add(teacherDTO);
        }

        return teacherDTOList;
    }

    @Override
    public String updateTeacher(TeacherUpdateDTO teacherUpdateDTO) {
        if(teacherRepo.existsById(teacherUpdateDTO.getTeacherId())){
            Teacher teacher = teacherRepo.getById(teacherUpdateDTO.getTeacherId());
            teacher.setTeacherName(teacherUpdateDTO.getTeacherName());
            teacher.setAddress(teacherUpdateDTO.getAddress());
            teacher.setPhoneNumber(teacherUpdateDTO.getPhoneNumber());
            teacherRepo.save(teacher);
            return teacher.getTeacherName();

        } else {
            System.out.println("Teacher not found");
        }

        return null;
    }

    @Override
    public boolean deleteTeacher(int id) {
        if(teacherRepo.existsById(id)){
            teacherRepo.deleteById(id);
        } else {
            System.out.println("Teacher not found");
        }

        return false;
    }
}
