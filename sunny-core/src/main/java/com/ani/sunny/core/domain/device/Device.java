package com.ani.sunny.core.domain.device;

import com.ani.agent.service.commons.object.enumeration.DeviceState;
import com.ani.sunny.core.domain.AbstractDomain;

/**
 * Created by wyf on 17-3-6.
 */
public class Device extends AbstractDomain {
    private static final long serialVersionUID = -6880977032756844692L;

    public String identificationCode;
    public Long masterId;
    public Integer slaveId;
    public String name;
    public DeviceState deviceState;
    public String deviceType;
    public String deviceModel;
    public String logoUrl;
    public Long ownerId;

    public Device() {
    }

    public Device(Long masterId, Integer slaveId,
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

    public void save(){

    }

    public void modify(){

    }

    public static String buildIdentificationCode(){
        return null;
    }

}
