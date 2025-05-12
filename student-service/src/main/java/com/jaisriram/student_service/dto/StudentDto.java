package com.jaisriram.student_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String id;
    private String name;
    private int age;
    private String gender;
    private SchoolDto school;
}
