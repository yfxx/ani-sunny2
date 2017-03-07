package com.ani.sunny.commons.dto.feature;

import com.ani.octopus.commons.stub.enumeration.PrivilegeType;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by wyf on 17-3-6.
 */
public class FeatureDto implements Serializable{
    private static final long serialVersionUID = -3851369909748020695L;

    public String featureId;
    public String featureName;
    public String description;
    public PrivilegeType privilegeType;

    public List<FeatureArgDto> argDtoList;
    public List<FeatureFunctionDto> featureFunctionDtoList;
    public List<Map<String, List<String>>> featureArgFuncArgMapList;

    public FeatureDto() {
    }

    public FeatureDto(List<FeatureArgDto> argDtoList, String description,
                            List<Map<String, List<String>>> featureArgFuncArgMapList,
                            List<FeatureFunctionDto> featureFunctionDtoList,
                            String featureId, String featureName, PrivilegeType privilegeType) {
        this.argDtoList = argDtoList;
        this.description = description;
        this.featureArgFuncArgMapList = featureArgFuncArgMapList;
        this.featureFunctionDtoList = featureFunctionDtoList;
        this.featureId = featureId;
        this.featureName = featureName;
        this.privilegeType = privilegeType;
    }

    @Override
    public String toString() {
        return "FeatureDto{" +
                "featureId='" + featureId + '\'' +
                ", featureName='" + featureName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
