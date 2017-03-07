package com.ani.sunny.commons.dto.device;

import com.ani.sunny.commons.dto.user.UserInfoDto;

import java.io.Serializable;

/**
 * Created by wyf on 17-3-6.
 */
public class DeviceAndUserRelationDto implements Serializable{
    private static final long serialVersionUID = -7701232371940004751L;

    public DeviceInfoDto deviceInfoDto;
    public UserInfoDto userInfoDto;
    public String recentParams;
    public String screenName;
    public String deviceGroup;

    public DeviceAndUserRelationDto(){}

    public DeviceAndUserRelationDto(DeviceInfoDto deviceInfoDto, UserInfoDto userInfoDto,
                                    String recentParams, String screenName, String deviceGroup){
        this.deviceInfoDto = deviceInfoDto;
        this.userInfoDto = userInfoDto;
        this.recentParams = recentParams;
        this.screenName = screenName;
        this.deviceGroup = deviceGroup;
    }

    @Override
    public String toString() {
        return "DeviceAndUserRelationDto{" +
                "deviceDto='" + deviceInfoDto.toString() + '\'' +
                ", userInfoDto='" + userInfoDto.toString() + '\'' +
                ", recentParams='" + recentParams + '\'' +
                ", screenName='" + screenName + '\'' +
                ", deviceGroup='" + deviceGroup + '\'' +
                '}';
    }
}
