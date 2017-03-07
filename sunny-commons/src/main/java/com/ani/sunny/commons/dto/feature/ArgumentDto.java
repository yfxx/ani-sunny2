package com.ani.sunny.commons.dto.feature;

import com.ani.agent.service.commons.object.enumeration.DataType;

import java.io.Serializable;

/**
 * Created by wyf on 17-3-6.
 */
public class ArgumentDto implements Serializable{
    private static final long serialVersionUID = 9180386588733645701L;

    public String name;
    public DataType dataType;

    public ArgumentDto() {
    }

    public ArgumentDto(DataType dataType, String name) {
        this.dataType = dataType;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ArgumentDto{" +
                "dataType=" + dataType +
                ", name='" + name + '\'' +
                '}';
    }
}
