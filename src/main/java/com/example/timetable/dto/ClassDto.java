package com.example.timetable.dto;

import com.example.timetable.enums.SubjectEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClassDto {
    public Long classId;
    public Integer number;
    public Integer strength;
    public Integer numberOfClassSections;
    public List<TeacherDto> teachers;
    public List<SubjectEnum> subjects;
}
