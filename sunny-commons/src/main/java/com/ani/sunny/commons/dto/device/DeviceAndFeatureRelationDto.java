package com.ani.sunny.commons.dto.device;

import com.ani.sunny.commons.dto.feature.FeatureDto;

import java.io.Serializable;

/**
 * Created by wyf on 17-3-6.
 */
public class DeviceAndFeatureRelationDto implements Serializable{
    private static final long serialVersionUID = 8248476150176556764L;

    public String deviceId;
    public FeatureDto featureDto;
    public String curState;

    public DeviceAndFeatureRelationDto(){

    }

    public DeviceAndFeatureRelationDto(String deviceId, FeatureDto featureDto, String curState) {
        this.deviceId = deviceId;
        this.featureDto = featureDto;
        this.curState = curState;
    }
}
