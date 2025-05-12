package com.jaisriram.student_service.controller;

import com.jaisriram.student_service.entity.Student;
import com.jaisriram.student_service.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/api/student")
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("{id}")
    public ResponseEntity<?> getStudentById(@PathVariable String id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @PostMapping()
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

}
