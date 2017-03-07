package com.ani.sunny.core.service.feature;

import com.ani.sunny.commons.dto.feature.FeatureFunctionDto;

/**
 * Created by wyf on 17-3-6.
 */
public interface FeatureFunctionService {
    FeatureFunctionDto getFeatureFunctionByStubIdAndGroupId(Integer stubId, Long groupId);
}
