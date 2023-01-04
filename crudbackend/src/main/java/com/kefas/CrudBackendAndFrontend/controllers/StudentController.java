package com.kefas.CrudBackendAndFrontend.controllers;

import com.kefas.CrudBackendAndFrontend.entities.Student;
import com.kefas.CrudBackendAndFrontend.service.StudentService;
import com.kefas.CrudBackendAndFrontend.studentDto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create-user")
    public ResponseEntity<StudentDto> createUser(@Valid @RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.createStudent(studentDto), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{studentId}/edit-student")
    public ResponseEntity<StudentDto> editStudent(@RequestBody StudentDto studentDto, @PathVariable Long studentId) {
        StudentDto editStudent = studentService.editStudent(studentDto, studentId);
        return new ResponseEntity<>(editStudent, HttpStatus.OK);

    }

    @DeleteMapping("/{studentId}/delete-student")
    public ResponseEntity<String> deleteUser(@PathVariable Long studentId){
        return new ResponseEntity<>(studentService.deleteStudent(studentId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-student/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId){
        Student student = studentService.getStudentById(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);

    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> student = studentService.getAllStudent();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
