package com.jaisriram.student_service.service;

import com.jaisriram.student_service.dto.SchoolDto;
import com.jaisriram.student_service.dto.StudentDto;
import com.jaisriram.student_service.dto.mapper.StudentMapper;
import com.jaisriram.student_service.entity.Student;
import com.jaisriram.student_service.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.naming.NameNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final RestTemplate restTemplate;

    @Value("${app.external.api}")
    private String schoolRESTAPI;

    @Transactional
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public ResponseEntity<?> getStudentById(String id)  {
        Student student = studentRepository.findById(id).orElse(null);
        if(student != null) {
            SchoolDto schoolDto = restTemplate.getForObject(schoolRESTAPI + "/" + student.getSchooldId(), SchoolDto.class);

            return new ResponseEntity<StudentDto>(StudentMapper.toStudentDto(student, schoolDto), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Student Found",HttpStatus.NOT_FOUND);
        }
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

}
