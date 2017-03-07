package com.ani.sunny.core.domain.feature;

import com.ani.agent.service.commons.object.enumeration.DataType;
import com.ani.sunny.commons.enumeration.ArgumentType;
import com.ani.sunny.core.domain.AbstractDomain;

/**
 * Created by wyf on 17-3-6.
 */
public class FunctionArgument extends AbstractDomain{
    private static final long serialVersionUID = -5954558914030096237L;

    public String name;
    public DataType dataType;
    public ArgumentType argumentType;

    public FunctionArgument() {
    }

    public FunctionArgument(ArgumentType argumentType, DataType dataType, String name) {
        this.argumentType = argumentType;
        this.dataType = dataType;
        this.name = name;
    }

    @Override
    public String toString() {
        return "FunctionArgument{" +
                "dataType=" + dataType +
                ", name='" + name + '\'' +
                '}';
    }
}
