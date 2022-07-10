package com.example.timetable.entity;

import com.example.timetable.dto.ClassDto;
import com.example.timetable.entity.base.BaseAuditableEntity;
import com.example.timetable.enums.SubjectEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "class")
public class Classs extends BaseAuditableEntity {

    @Column(name = "number")
    private Integer number;

    @Column(name = "strength")
    private Integer strength;

    @Column(name = "sections")
    private Integer numberOfSections;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "class_id")
    private List<ClassSubject> subjects;

    @Fetch(FetchMode.SELECT)
    @OneToMany(
            mappedBy = "aClass",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @Where(clause = "IF(is_active IS NOT NULL, is_active=1, true)")
    private List<Teacher> teachers;

    public ClassDto to() {
        ClassDto classDto = ClassDto.builder()
                .classId(this.getId())
                .strength(this.getStrength())
                .number(this.getNumber())
                .numberOfClassSections(this.getNumberOfSections())
                .teachers(getTeachers().stream().map(teacher -> teacher.to()).collect(Collectors.toList()))
                .build();
        List<ClassSubject> classSubjects = this.getSubjects();
        List<SubjectEnum> subjectEnums = classSubjects.stream().map(subject -> SubjectEnum.getByCode(subject.getSubjectId())).collect(Collectors.toList());
        classDto.setSubjects(subjectEnums);
        return classDto;
    }

    public static Classs convert(ClassDto classDto) {
        return Classs.builder()
                .strength(classDto.getStrength())
                .number(classDto.getNumber())
                .numberOfSections(classDto.getNumberOfClassSections())
                .build();
    }

}
