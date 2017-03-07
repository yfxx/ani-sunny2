package com.ani.sunny.core.service.device;

import com.ani.sunny.commons.dto.device.DeviceAndFeatureRelationDto;

import java.util.List;

/**
 * Created by wyf on 17-3-6.
 */
public interface DeviceAndFeatureRelationService {
    DeviceAndFeatureRelationDto save(DeviceAndFeatureRelationDto deviceAndFeatureRelationDto);

    void batchSave(List<DeviceAndFeatureRelationDto> relationDtoList);

    void batchModify(List<DeviceAndFeatureRelationDto> relationDtoList);

    DeviceAndFeatureRelationDto findByDeviceIdentificationCode(String identificationCode);

    List<DeviceAndFeatureRelationDto> findAll();

    List<DeviceAndFeatureRelationDto> findByHashUserId(Long hashUserId);

    void removeByDeviceId(String identificationCode);
}
