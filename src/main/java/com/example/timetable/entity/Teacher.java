package com.example.timetable.entity;

import com.example.timetable.dto.TeacherDto;
import com.example.timetable.entity.base.BaseAuditableEntity;
import com.example.timetable.enums.SubjectEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "teacher")
public class Teacher extends BaseAuditableEntity {

    @Column(name = "class_id")
    private Long classId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", insertable = false, updatable = false)
    private Classs aClass;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "subject")
    private Integer subject;

    public TeacherDto to(){
        return TeacherDto.builder()
                .teacherId(this.getId())
                .classId(this.getClassId())
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .email(this.getEmail())
                .subject(SubjectEnum.getByCode(getSubject()))
                .build();
    }

    public static Teacher convert(TeacherDto teacherDto) {
        return Teacher.builder()
                .classId(teacherDto.getClassId())
                .firstName(teacherDto.getFirstName())
                .lastName(teacherDto.getLastName())
                .subject(teacherDto.getSubject().getCode())
                .email(teacherDto.getEmail())
                .build();
    }
    
}
