package com.jaisriram.school_service.service;

import com.jaisriram.school_service.entity.School;
import com.jaisriram.school_service.repository.SchoolRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Transactional
    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    public School getSchoolById(Long id) {
        return schoolRepository.findById(id).orElse(null);
    }

    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

}
