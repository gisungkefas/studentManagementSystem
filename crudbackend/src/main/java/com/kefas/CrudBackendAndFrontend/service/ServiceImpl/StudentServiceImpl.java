package com.kefas.CrudBackendAndFrontend.service.ServiceImpl;

import com.kefas.CrudBackendAndFrontend.entities.Student;
import com.kefas.CrudBackendAndFrontend.exception.StudentAlreadyExistException;
import com.kefas.CrudBackendAndFrontend.exception.StudentNotFoundException;
import com.kefas.CrudBackendAndFrontend.repository.StudentRepository;
import com.kefas.CrudBackendAndFrontend.service.StudentService;
import com.kefas.CrudBackendAndFrontend.studentDto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student students = new Student();

        boolean existUser = studentRepository.findByEmail(studentDto.getEmail()).isPresent();
        if(existUser){
            throw new StudentAlreadyExistException("User with "+studentDto.getEmail()+"Already Exist");
        }

        students.setEmail(studentDto.getEmail());
        students.setFirstName(studentDto.getFirstName());
        students.setLastName(studentDto.getLastName());
        students.setGender(studentDto.getGender());
        students.setDob(studentDto.getDob());
        students.setPhoneNumber(studentDto.getPhoneNumber());
        students.setAddress(studentDto.getAddress());
        studentRepository.save(students);

        return studentDto;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public StudentDto editStudent(StudentDto studentDto, Long studentId) {
        Student student= studentRepository.findById(studentId).
                orElseThrow(()-> new StudentNotFoundException("User with ID: "+ studentId +" is not found"));

        if(studentDto.getEmail() != null && !studentDto.getEmail().equals(student.getEmail())){
            student.setEmail(studentDto.getEmail());
        }

        if(studentDto.getFirstName() != null && !studentDto.getFirstName().equals(student.getFirstName())){
            student.setFirstName(studentDto.getFirstName());
        }

        if (studentDto.getLastName() != null && !studentDto.getLastName().equals(student.getLastName())){
            student.setLastName(studentDto.getLastName());
        }

        if (studentDto.getGender() != null && !studentDto.getGender().equals(student.getGender())){
            student.setGender(studentDto.getGender());
        }

        if (studentDto.getDob() != null && !studentDto.getDob().equals(student.getDob())){
            student.setDob(studentDto.getDob());
        }

        if (studentDto.getPhoneNumber() != null && !studentDto.getPhoneNumber().equals(student.getPhoneNumber())){
            student.setPhoneNumber(studentDto.getPhoneNumber());
        }

        if (studentDto.getAddress() != null && !studentDto.getAddress().equals(student.getAddress())){
            student.setAddress(studentDto.getAddress());
        }

        studentRepository.save(student);

        return studentDto;
    }

    @Override
    public String deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).
                orElseThrow(()-> new StudentNotFoundException("User with ID: "+ studentId +" is not found"));

        studentRepository.delete(student);
        return "User Deleted Successfully";
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> {
                    throw new StudentNotFoundException("User with ID: " + studentId + " Not Found");
                });
    }
}
