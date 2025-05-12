package com.jaisriram.student_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {
    private Long id;
    private String name;
    private String location;
    private String principalName;
}
