package com.example.timetable.service.impl;

import com.example.timetable.dao.ClassDao;
import com.example.timetable.dto.ClassDto;
import com.example.timetable.service.ClassService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Data
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClassServiceImpl implements ClassService {
    private final ClassDao classDao;

    @Override
    public Collection<ClassDto> getAllClassData() {
        return classDao.getAllClassData();
    }

    @Override
    public ClassDto getClassData(Long id) throws Exception {
       return classDao.getClassData(id);
    }

    @Override
    public void addClass(ClassDto classDto) throws Exception {
        validateClassDto(classDto);
        classDao.save(classDto);
    }

    private void validateClassDto(ClassDto classDto) throws Exception {
        if(Objects.isNull(classDto) || Objects.isNull(classDto.getNumberOfClassSections()) ||
                classDto.getNumberOfClassSections() > 4 || classDto.getNumberOfClassSections() < 1)
            throw new Exception("Invalid number of sections");
    }
}
