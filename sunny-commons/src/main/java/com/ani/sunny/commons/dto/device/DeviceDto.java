package com.ani.sunny.commons.dto.device;

import com.ani.agent.service.commons.object.enumeration.DeviceState;

import java.io.Serializable;

/**
 * Created by wyf on 17-3-6.
 */
public class DeviceDto implements Serializable{
    private static final long serialVersionUID = 315138556589693386L;

    public String identificationCode;
    public Long masterId;
    public Integer slaveId;
    public String name;
    public DeviceState deviceState;
    public String deviceType;
    public String deviceModel;
    public String logoUrl;
    public Long ownerId;

    public DeviceDto() {
    }

    public DeviceDto(Long masterId, Integer slaveId,
                  DeviceState deviceState,
                  String deviceType,
                  String deviceModel,
                  String identificationCode,
                  String name, Long ownerId, String logoUrl) {
        this.masterId = masterId;
        this.slaveId = slaveId;
        this.deviceState = deviceState;
        this.deviceType = deviceType;
        this.deviceModel = deviceModel;
        this.identificationCode = identificationCode;
        this.name = name;
        this.ownerId = ownerId;
        this.logoUrl = logoUrl;
    }
}
