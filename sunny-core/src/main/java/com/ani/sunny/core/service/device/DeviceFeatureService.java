package com.ani.sunny.core.service.device;

import com.ani.sunny.commons.dto.feature.FeatureDto;
import com.ani.sunny.commons.dto.feature.FeatureInfoDto;

import java.util.List;

/**
 * Created by zhaoyu on 15-6-12.
 */
public interface DeviceFeatureService {
    /**
     * generate the feature num by UUID
     * @param deviceFeatureDto
     * @return
     */

    public FeatureDto saveDeviceFeature(FeatureDto deviceFeatureDto);

    public void batchSaveDeviceFeature(List<FeatureDto> deviceFeatureDtoList);

    /**
     * just can modify feature name and description
     * @param deviceFeatureDto
     * @return
     */
    public FeatureDto modifyDeviceFeature(FeatureDto deviceFeatureDto);
    public void removeDeviceFeature(String deviceFeatureId);
    public FeatureDto getDeviceFeatureById(String deviceFeatureId);
    public List<FeatureDto> getAllDeviceFeature();
    public List<FeatureInfoDto> getAllDeviceFeatureInfo();
}
