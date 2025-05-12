package com.jaisriram.student_service.dto.mapper;

import com.jaisriram.student_service.dto.SchoolDto;
import com.jaisriram.student_service.dto.StudentDto;
import com.jaisriram.student_service.entity.Student;

public class StudentMapper {

    public static StudentDto toStudentDto(Student student, SchoolDto schoolDto) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setSchool(schoolDto);
        studentDto.setGender(student.getGender());
        studentDto.setAge(student.getAge());
        return studentDto;
    }

}
