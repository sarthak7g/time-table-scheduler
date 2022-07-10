package com.example.timetable.dto;

import com.example.timetable.enums.SubjectEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherDto {
    public Long teacherId;
    public Long classId;
    public String firstName;
    public String lastName;
    public String email;
    public SubjectEnum subject;
}

