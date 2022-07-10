package com.example.timetable.dao.impl;

import com.example.timetable.dao.ClassDao;
import com.example.timetable.dto.ClassDto;
import com.example.timetable.entity.ClassSubject;
import com.example.timetable.entity.Classs;
import com.example.timetable.repository.ClassRepository;
import com.example.timetable.repository.ClassSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClassDaoImpl implements ClassDao {

    private final ClassRepository classRepository;
    private final ClassSubjectRepository subjectRepository;

    @Override
    @Transactional
    public void save(ClassDto classDto) {
        Classs classs = Classs.convert(classDto);
        List<ClassSubject> classSubjects = classDto.getSubjects().stream().map(subjectEnum -> {
            return ClassSubject.builder()
                    .aClass(classs)
                    .subjectId(subjectEnum.getCode())
                    .build();
        }).collect(Collectors.toList());
        subjectRepository.saveAll(classSubjects);
        classs.setSubjects(classSubjects);
        classRepository.save(classs);
    }

    @Override
    public Collection<ClassDto> getAllClassData() {
        return classRepository.findAll().stream().map(o -> o.to()).collect(Collectors.toList());
    }

    public ClassDto getClassData(Long id) throws Exception {
        Classs classs = classRepository.findById(id).orElseThrow(() -> new Exception("Class not found"));
        return classs.to();
    }
}
