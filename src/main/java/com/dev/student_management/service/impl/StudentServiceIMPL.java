package com.dev.student_management.service.impl;

import com.dev.student_management.dto.StudentDTO;
import com.dev.student_management.dto.StudentSaveDTO;
import com.dev.student_management.dto.StudentUpdateDTO;
import com.dev.student_management.entity.Student;
import com.dev.student_management.repo.StudentRepo;
import com.dev.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {

        Student student = new Student(
                studentSaveDTO.getStudentName(),
                studentSaveDTO.getAddress(),
                studentSaveDTO.getPhoneNumber()
        );

        studentRepo.save(student);

        return student.getStudentName() + " adaugat cu success!";
    }

    @Override
    public List<StudentDTO> getAllStudents() {

        List<Student> getStudents = studentRepo.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for(Student student : getStudents){
            StudentDTO studentDTO = new StudentDTO(
                    student.getStudentId(),
                    student.getStudentName(),
                    student.getAddress(),
                    student.getPhoneNumber()
            );
            studentDTOList.add(studentDTO);
        }

        return studentDTOList;
    }

    @Override
    public String updateStudent(StudentUpdateDTO studentUpdateDTO) {
        if(studentRepo.existsById(studentUpdateDTO.getStudentId())){
            Student student = studentRepo.getById(studentUpdateDTO.getStudentId());
            student.setStudentName(studentUpdateDTO.getStudentName());
            student.setAddress(studentUpdateDTO.getAddress());
            student.setPhoneNumber(studentUpdateDTO.getPhoneNumber());
            studentRepo.save(student);
            return student.getStudentName();

        } else {
            System.out.println("Student not found");
        }

        return null;
    }

    @Override
    public boolean deleteStudent(int id) {

        if(studentRepo.existsById(id)){
            studentRepo.deleteById(id);
        }else {
            System.out.println("Student not found");
        }

        return false;
    }
}
