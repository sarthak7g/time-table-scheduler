package com.example.timetable.service;

import com.example.timetable.dto.TeacherDto;

import java.util.Collection;

public interface TeacherService {
    Collection<TeacherDto> getAllTeachersData();

    TeacherDto getTeacher(Long id) throws Exception;

    void addTeacher(TeacherDto teacherDto) throws Exception;
}
