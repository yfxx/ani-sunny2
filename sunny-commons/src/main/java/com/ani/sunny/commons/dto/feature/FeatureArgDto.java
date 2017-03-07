package com.ani.sunny.commons.dto.feature;

import com.ani.agent.service.commons.object.enumeration.DataType;
import com.ani.sunny.commons.enumeration.ArgScopeType;

/**
 * Created by wyf on 17-3-6.
 */
public class FeatureArgDto extends ArgumentDto{

    public String screenName;
    public ArgScopeType scopeType;
    public String scopeValue;

    public FeatureArgDto(){
        super();
    }

    public FeatureArgDto(String screenName) {
        this.screenName = screenName;
    }

    public FeatureArgDto(DataType dataType, String name, String screenName, ArgScopeType argScopeType, String scopeValue) {
        super(dataType, name);
        this.screenName = screenName;
        this.scopeType = argScopeType;
        this.scopeValue = scopeValue;
    }

    @Override
    public String toString() {
        return "FeatureArgDto{" +
                "screenName='" + screenName + '\'' +
                '}';
    }
}
