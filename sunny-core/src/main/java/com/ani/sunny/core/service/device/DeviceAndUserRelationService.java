package com.ani.sunny.core.service.device;

import com.ani.sunny.commons.dto.device.DeviceAndUserRelationDto;
import com.ani.sunny.commons.dto.user.UserDto;

import java.util.List;

/**
 * Created by wyf on 17-3-6.
 */
public interface DeviceAndUserRelationService {
    DeviceAndUserRelationDto saveRelation(DeviceAndUserRelationDto relationDto);

    void batchSave(List<DeviceAndUserRelationDto> relationDtoList);

    DeviceAndUserRelationDto modifyRelation(DeviceAndUserRelationDto relationDto);

    void batchModify(List<DeviceAndUserRelationDto> relationDtoList);

    void removeRelation(DeviceAndUserRelationDto relationDto);

    void removeRelationsWithDeviceId(String identificationCode);

    void batchRemove(List<DeviceAndUserRelationDto> relations);

    List<DeviceAndUserRelationDto> getRelationsByUserId(Long hashUserId);

    DeviceAndUserRelationDto getDeviceAndUserRelation(String identificationCode, Long hashUserId);

    List<Long> findUserIdByDeviceId(String deviceId);

    List<DeviceAndUserRelationDto> getRelationsByDeviceId(String identificationCode);
}
