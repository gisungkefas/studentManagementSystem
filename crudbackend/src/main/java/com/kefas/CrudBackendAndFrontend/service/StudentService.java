package com.kefas.CrudBackendAndFrontend.service;

import com.kefas.CrudBackendAndFrontend.entities.Student;
import com.kefas.CrudBackendAndFrontend.studentDto.StudentDto;
import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);

    StudentDto editStudent(StudentDto studentDto, Long studentId);

    String deleteStudent(Long studentId);

    Student getStudentById(Long studentId);

    List<Student> getAllStudent();
}
