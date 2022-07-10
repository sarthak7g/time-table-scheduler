package com.example.timetable.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum SubjectEnum {
    PHYSICS(1),
    CHEMISTRY(2),
    MATHS(3),
    ENGLISH(4),
    HINDI(5);


    @Getter(onMethod = @__(@JsonValue))
    private Integer code;

    @JsonCreator
    public static SubjectEnum getByCode(Integer code) {
        for(SubjectEnum e: Arrays.asList(values())) {
            if(code.equals(e.getCode()))
                return e;
        }
        return null;
    }
}
