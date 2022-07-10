package com.example.timetable.dao;

import com.example.timetable.dto.ClassDto;

import java.util.Collection;


public interface ClassDao {
    void save(ClassDto classDto);

    Collection<ClassDto> getAllClassData();

    ClassDto getClassData(Long id) throws Exception;
}
