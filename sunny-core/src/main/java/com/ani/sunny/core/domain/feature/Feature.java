package com.ani.sunny.core.domain.feature;

import com.ani.octopus.commons.stub.enumeration.PrivilegeType;
import com.ani.sunny.commons.dto.feature.FeatureArgDto;
import com.ani.sunny.core.domain.AbstractDomain;

import java.util.List;
import java.util.Map;

/**
 * Created by wyf on 17-3-6.
 */
public class Feature extends AbstractDomain {
    private static final long serialVersionUID = -5472106008704407806L;

    public String featureId;
    public String featureName;
    public String description;
    public PrivilegeType privilegeType;

    public List<FeatureArgDto> featureArgList;
    public List<FeatureFunction> featureFunctionList;
    public List<Map<String, List<String>>> featureArgFuncArgMapList;
}
