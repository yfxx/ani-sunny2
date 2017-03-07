package com.ani.sunny.commons.dto.feature;

import java.io.Serializable;

/**
 * Created by wyf on 17-3-6.
 */
public class FeatureArgValueDto implements Serializable{
    private static final long serialVersionUID = 6020593788122188489L;

    public String argName;
    public String value;

    public FeatureArgValueDto() {
    }

    public FeatureArgValueDto(String argName, String value) {
        this.argName = argName;
        this.value = value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeatureArgValueDto that = (FeatureArgValueDto) o;

        if (argName != null ? !argName.equals(that.argName) : that.argName != null) return false;
        return !(value != null ? !value.equals(that.value) : that.value != null);

    }

    @Override
    public int hashCode() {
        int result = argName != null ? argName.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "FeatureArgValueDto{" +
                "argName='" + argName + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
