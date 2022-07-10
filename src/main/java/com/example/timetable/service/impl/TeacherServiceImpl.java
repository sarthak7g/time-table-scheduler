package com.example.timetable.service.impl;

import com.example.timetable.dao.TeacherDao;
import com.example.timetable.dto.TeacherDto;
import com.example.timetable.service.ClassService;
import com.example.timetable.service.TeacherService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Data
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherServiceImpl implements TeacherService {
    private final TeacherDao teacherDao;
    private final ClassService classService;

    @Override
    public Collection<TeacherDto> getAllTeachersData() {
        return teacherDao.getAllTeachersData();
    }

    @Override
    public TeacherDto getTeacher(Long id) throws Exception {
        return teacherDao.getTeacherData(id);
    }

    @Override
    public void addTeacher(TeacherDto teacherDto) throws Exception {
        if(Objects.isNull(teacherDto) || Objects.isNull(teacherDto.getSubject())) {
            throw new Exception("Invalid input");
        }
        validateClassExists(teacherDto.getClassId());
        teacherDao.save(teacherDto);
    }

    private void validateClassExists(Long classId) throws Exception {
        classService.getClassData(classId);
    }
}
