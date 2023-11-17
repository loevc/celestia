package com.loevc.celestia.admin.factory.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public enum FactoryEnum {


    ROAD("road"),

    SEA("sea"),
    ;

    private String name;

    FactoryEnum(String name){
        this.name = name;
    }


    public static FactoryEnum getFactoryEnumByName(String name) {
        for (FactoryEnum value : values()) {
            if (value.getName().equals(name)) return value;
        }
        return null;
    }
}
