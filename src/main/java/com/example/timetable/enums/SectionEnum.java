package com.example.timetable.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum SectionEnum {
    A(1),
    B(2),
    C(3),
    D(4);


    @Getter(onMethod = @__(@JsonValue))
    private Integer code;

    @JsonCreator
    public SectionEnum getByCode(Integer code) {
        for(SectionEnum e: Arrays.asList(values())) {
            if(code.equals(e.getCode()))
                return e;
        }
        return null;
    }
}
