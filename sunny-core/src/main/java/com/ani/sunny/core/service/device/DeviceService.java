package com.ani.sunny.core.service.device;

import com.ani.agent.service.commons.object.enumeration.DeviceState;
import com.ani.sunny.commons.dto.device.DeviceDto;

import java.util.List;

/**
 * Created by wyf on 17-3-6.
 */
public interface DeviceService {
    void saveDevice(DeviceDto deviceDto);

    void batchSave(List<DeviceDto> deviceDtoList);

    DeviceDto modifyDevice(DeviceDto deviceDto);

    void removeDevice(DeviceDto deviceDto);

    void modifyDeviceState(DeviceDto deviceDto, DeviceState deviceState);

    DeviceDto getDeviceByIdentificationCode(String identificationCode);

    List<DeviceDto> getDeviceByUserId(Long hashUserId);

    List<DeviceDto> getDeviceByUserIdAndGroup(Long hashUserId, String deviceGroup);

    List<DeviceDto> getDeviceByUserAndType(Long hashUserId, String deviceType);

    List<DeviceDto> getDeviceByUserAndState(Long hashUserId, DeviceState state);

    List<String> getUserDeviceGroupList(Long hashUserId);
}
