package com.ani.sunny.core.domain.strategy;

import com.ani.sunny.commons.dto.feature.FeatureArgValueDto;
import com.ani.sunny.core.domain.AbstractDomain;
import com.ani.sunny.core.domain.device.Device;
import com.ani.sunny.core.domain.feature.Feature;

import java.util.List;

/**
 * Created by wyf on 17-3-6.
 */
public class DeviceFeatureInstance extends AbstractDomain {
    private static final long serialVersionUID = -7178427714849903660L;

    public String featureInstanceId;
    public Device device;
    public Feature feature;
    public List<FeatureArgValueDto> featureArgValueList;
    public List<FeatureTrigger> triggerList;

    public Long intervalTime;

    public DeviceFeatureInstance() {
    }

    public DeviceFeatureInstance(String featureInstanceId, Device device,
                                 Feature feature,
                                 List<FeatureArgValueDto> featureArgValueList,
                                 List<FeatureTrigger> triggerList,
                                 Long intervalTime) {
        this.featureInstanceId = featureInstanceId;
        this.device = device;
        this.feature = feature;
        this.featureArgValueList = featureArgValueList;
        this.triggerList = triggerList;
        this.intervalTime = intervalTime;
    }
}
