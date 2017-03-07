package com.ani.sunny.core.service.feature;

import com.ani.sunny.commons.dto.feature.FeatureDto;
import com.ani.sunny.commons.dto.feature.FeatureInfoDto;

import java.util.List;

/**
 * Created by wyf on 17-3-6.
 */
public interface FeatureService {
    FeatureDto saveFeature(FeatureDto featureDto);

    void batchSaveFeature(List<FeatureDto> featureDtoList);

    FeatureDto modifyFeature(FeatureDto featureDto);

    void removeFeature(String featureId);

    FeatureDto getFeatureById(String featureId);

    List<FeatureDto> getAllFeature();

    List<FeatureInfoDto> getAllFeatureInfo();
}
