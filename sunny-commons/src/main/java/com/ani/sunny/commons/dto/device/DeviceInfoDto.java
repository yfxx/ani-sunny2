package com.ani.sunny.commons.dto.device;

import com.ani.agent.service.commons.object.enumeration.DeviceState;

import java.io.Serializable;

/**
 * Created by wyf on 17-3-6.
 */
public class DeviceInfoDto implements Serializable{
    private static final long serialVersionUID = -1542541414435302994L;

    public String identificationCode;       // id of device, consist of masterDeviceId and slaveDeviceId
    public String name;
    public DeviceState deviceState;
    public String deviceType;
    public String deviceGroup;
    public String logoUrl;

    public DeviceInfoDto() {
    }

    public DeviceInfoDto(String deviceGroup, DeviceState deviceState, String deviceType,
                         String identificationCode, String name, String logoUrl) {
        this.deviceGroup = deviceGroup;
        this.deviceState = deviceState;
        this.deviceType = deviceType;
        this.identificationCode = identificationCode;
        this.name = name;
        this.logoUrl = logoUrl;
    }

    @Override
    public String toString() {
        return "DeviceDto{" +
                "deviceGroup='" + deviceGroup + '\'' +
                ", identificationCode='" + identificationCode + '\'' +
                ", name='" + name + '\'' +
                ", deviceState=" + deviceState +
                ", deviceType='" + deviceType + '\'' +
                '}';
    }
}
