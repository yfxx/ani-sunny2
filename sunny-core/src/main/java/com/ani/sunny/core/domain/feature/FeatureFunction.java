package com.ani.sunny.core.domain.feature;

import com.ani.agent.service.commons.object.enumeration.FunctionType;
import com.ani.sunny.core.domain.AbstractDomain;

import java.util.List;

/**
 * Created by wyf on 17-3-6.
 */
public class FeatureFunction extends AbstractDomain{
    private static final long serialVersionUID = 6263502105438562340L;

    public String featureFunctionId;
    public Integer stubId;
    public Long groupId;
    public String functionName;
    public FunctionType functionType;
    public List<FunctionArgument> inputArgList;
    public List<FunctionArgument> outputArgList;

    public FeatureFunction() {
    }

    public FeatureFunction(String featureFunctionId, Integer stubId, Long groupId,
                           String functionName, FunctionType functionType,
                           List<FunctionArgument> inputArgList,
                           List<FunctionArgument> outputArgList) {
        this.featureFunctionId = featureFunctionId;
        this.stubId = stubId;
        this.groupId = groupId;
        this.functionName = functionName;
        this.functionType = functionType;
        this.inputArgList = inputArgList;
        this.outputArgList = outputArgList;
    }

    @Override
    public String toString() {
        return "FeatureFunction{" +
                "functionType=" + functionType +
                ", functionName='" + functionName + '\'' +
                ", groupId=" + groupId +
                ", stubId=" + stubId +
                ", featureFunctionId='" + featureFunctionId + '\'' +
                "} " + super.toString();
    }
}
