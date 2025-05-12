package com.jaisriram.school_service.controller;

import com.jaisriram.school_service.entity.School;
import com.jaisriram.school_service.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/school")
@CrossOrigin("*")
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping()
    public ResponseEntity<List<School>> getAllSchools() {
        return ResponseEntity.ok(schoolService.getSchools());
    }

    @GetMapping("{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long id) {
        return ResponseEntity.ok(schoolService.getSchoolById(id));
    }

    @PostMapping()
    public ResponseEntity<School> createSchool(@RequestBody School school) {
        return ResponseEntity.ok(schoolService.saveSchool(school));
    }


}
