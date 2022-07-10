package com.example.timetable.dao.impl;

import com.example.timetable.dao.TeacherDao;
import com.example.timetable.dto.TeacherDto;
import com.example.timetable.entity.Teacher;
import com.example.timetable.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherDaoImpl implements TeacherDao {

    private final TeacherRepository teacherRepository;

    @Override
    public Teacher save(TeacherDto teacherDto) {
        return teacherRepository.save(Teacher.convert(teacherDto));
    }

    @Override
    public Collection<TeacherDto> getAllTeachersData() {
        return teacherRepository.findAll().stream().map(o -> o.to()).collect(Collectors.toList());
    }

    @Override
    public TeacherDto getTeacherData(Long id) throws Exception {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new Exception("Teacher does not exists!"));
        return teacher.to();
    }

}