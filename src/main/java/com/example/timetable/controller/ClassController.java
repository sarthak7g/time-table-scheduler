package com.example.timetable.controller;

import com.example.timetable.dto.ClassDto;
import com.example.timetable.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/class")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClassController {

    private final ClassService classService;

    /**
     * This method will get all class data
     **/
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Collection<ClassDto> getAll() {
        return classService.getAllClassData();
    }


    /**
     * This method will get a class data by id
     **/
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ClassDto get(@PathVariable long id) throws Exception {
        return classService.getClassData(id);
    }

    /**
     * This method will create a class
     **/
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String add(@RequestBody ClassDto classDto) throws Exception {
        classService.addClass(classDto);
        return "Class Created!";
    }

}
