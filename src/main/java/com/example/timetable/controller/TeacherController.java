package com.example.timetable.controller;

import com.example.timetable.dto.TeacherDto;
import com.example.timetable.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherController {

    private final TeacherService teacherService;

    /**
     * This method will get all teachers' data
     **/
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Collection<TeacherDto> getAll() {
        return teacherService.getAllTeachersData();
    }


    /**
     * This method will get a teacher data by id
     **/
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TeacherDto get(@PathVariable long id) throws Exception {
        return teacherService.getTeacher(id);
    }

    /**
     * This method will add a teacher
     **/
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String add(@RequestBody TeacherDto teacherDto) throws Exception {
        teacherService.addTeacher(teacherDto);
        return "Teacher Added!";
    }

}
