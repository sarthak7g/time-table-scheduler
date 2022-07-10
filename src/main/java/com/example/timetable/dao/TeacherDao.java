package com.example.timetable.dao;

import com.example.timetable.dto.TeacherDto;
import com.example.timetable.entity.Teacher;

import java.util.Collection;

public interface TeacherDao {
    Teacher save(TeacherDto teacherDto);

    Collection<TeacherDto> getAllTeachersData();

    TeacherDto getTeacherData(Long id) throws Exception;
}
