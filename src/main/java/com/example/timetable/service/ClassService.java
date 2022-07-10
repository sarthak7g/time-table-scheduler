package com.example.timetable.service;

import com.example.timetable.dto.ClassDto;

import java.util.Collection;

public interface ClassService {
    Collection<ClassDto> getAllClassData();

    ClassDto getClassData(Long id) throws Exception;

    void addClass(ClassDto classDto) throws Exception;
}
