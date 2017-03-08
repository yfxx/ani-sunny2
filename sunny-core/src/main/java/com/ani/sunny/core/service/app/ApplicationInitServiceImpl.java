package com.ani.sunny.core.service.app;

import com.ani.agent.service.commons.oauth.dto.AniOAuthAccessToken;
import com.ani.agent.service.commons.object.enumeration.DeviceState;
import com.ani.agent.service.service.AgentTemplate;
import com.ani.bus.service.commons.dto.anidevice.DeviceMasterObjInfoDto;
import com.ani.bus.service.commons.dto.anidevice.DeviceSlaveObjInfoDto;
import com.ani.earth.commons.dto.AccountDto;
import com.ani.octopus.commons.object.enumeration.AniObjectState;
import com.ani.octopus.commons.stub.dto.StubInfoDto;
import com.ani.sunny.commons.constant.Constants;
import com.ani.sunny.commons.dto.device.DeviceAndFeatureRelationDto;
import com.ani.sunny.commons.dto.device.DeviceAndUserRelationDto;
import com.ani.sunny.commons.dto.device.DeviceDto;
import com.ani.sunny.commons.dto.feature.FeatureDto;
import com.ani.sunny.commons.dto.feature.FeatureFunctionDto;
import com.ani.sunny.commons.dto.user.UserDto;
import com.ani.sunny.commons.enumeration.DeviceLogicState;
import com.ani.sunny.core.domain.device.Device;
import com.ani.sunny.core.service.device.*;
import com.ani.sunny.core.service.user.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by lihui on 17-3-7.
 */
public class ApplicationInitServiceImpl extends ApplicationInitService {
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ApplicationInitServiceImpl.class);
    @Resource(name = "agentTemplate")
    private AgentTemplate agentTemplate;
    @Resource
    private UserService userService;
    @Resource
    private DeviceService deviceService;
    @Resource
    private DeviceAndFeatureRelationService deviceAndFeatureRelationService;
    @Resource
    private DeviceInfoGeneratorService deviceInfoGeneratorService;
    @Resource
    private DeviceAndUserRelationService deviceAndUserRelationService;
    @Resource
    private DeviceFeatureService deviceFeatureService;

    private static List<FeatureDto> deviceFeatureDtos;

    @PostConstruct
    protected void getAllDeviceFeature() {
        deviceFeatureDtos = deviceFeatureService.getAllDeviceFeature();
    }

    @Override
    protected UserDto initUser(UserDto userDto) {
        LOGGER.info("initUser {}.", userDto);
        return userService.saveUser(userDto);
    }

    @Override
    protected void initUserDeviceAndDeviceFeatureRelation(UserDto userDto, List<DeviceMasterObjInfoDto> deviceMasterObjInfoDtoList) throws Exception {
        LOGGER.info("initUserDeviceAndDeviceFeatureRelation");
        if(deviceMasterObjInfoDtoList!=null){
            LOGGER.info("deviceMasterObjInfoDtoList size is "+deviceMasterObjInfoDtoList.size());
            List<DeviceAndFeatureRelationDto> deviceAndFeatureRelationDtos =
                    getRelation(deviceMasterObjInfoDtoList);
            LOGGER.info("Initialize DeviceAndFeatureRelation...");
            deviceAndFeatureRelationService.batchSave(deviceAndFeatureRelationDtos);
            List<DeviceAndUserRelationDto> deviceAndUserRelationDtoList =
                    getDeviceAndUserRelations(deviceAndFeatureRelationDtos, userDto);
            deviceAndUserRelationService.batchSave(deviceAndUserRelationDtoList);
        }
    }

    @Override
    protected boolean isUserNotExists(Long accountId) {
        UserDto userDto = userService.getUserByHashUserId(accountId);
        return userDto == null;
    }

    @Override
    public UserDto initApplication(AniOAuthAccessToken accessToken) throws Exception {
        AccountDto accountDto = agentTemplate
                .getAccountService(accessToken.getAccessToken())
                .getByAccessToken();
        UserDto userDto = fetchUserInfo(accountDto, accessToken);
        List<DeviceMasterObjInfoDto> deviceMasterObjInfoDtoList = agentTemplate
                .getDeviceObjService(accessToken.getAccessToken())
                .getAccessibleDeviceObjInfoList(userDto.hashUserId, Boolean.TRUE);
        if (isUserNotExists(accountDto.accountId)) {
            // init user
            initUser(userDto);
            // init user-device-devicefeature relation
            initUserDeviceAndDeviceFeatureRelation(userDto, deviceMasterObjInfoDtoList);

        }else{
            initUser(userDto);

            if(deviceMasterObjInfoDtoList != null && deviceMasterObjInfoDtoList.size() >0) {
                for(DeviceMasterObjInfoDto deviceMasterObjInfoDto:deviceMasterObjInfoDtoList) {
                    DeviceDto deviceDto = deviceService.getDeviceByIdentificationCode(Device.buildIdentificationCode(deviceMasterObjInfoDto.objectId, -1));
                    if (deviceDto == null) {
                        updateUserDeviceAndDeviceFeatureRelation(deviceMasterObjInfoDto);
                    }
                    deviceDto = deviceService.getDeviceByIdentificationCode(Device.buildIdentificationCode(deviceMasterObjInfoDto.objectId, -1));
                    DeviceAndUserRelationDto relationDto = new DeviceAndUserRelationDto(deviceDto,userDto,"{}",deviceDto.name,"default");
                    List<DeviceAndUserRelationDto> relationDtos = new ArrayList<>();
                    relationDtos.add(relationDto);

                    if (deviceMasterObjInfoDto.slaves != null && deviceMasterObjInfoDto.slaves.size() > 0) {
                        for (DeviceSlaveObjInfoDto slaveObjInfoDto : deviceMasterObjInfoDto.slaves) {
                            DeviceDto slaveDeviceDto = deviceService.getDeviceByIdentificationCode(Device.buildIdentificationCode(deviceMasterObjInfoDto.objectId, slaveObjInfoDto.objectSlaveId));
                            DeviceAndUserRelationDto slaveRelationDto = new DeviceAndUserRelationDto(slaveDeviceDto, userDto, "{}", slaveDeviceDto.name, "default");
                            relationDtos.add(slaveRelationDto);
                        }
                    }
                    List<DeviceAndUserRelationDto> orgRelations = deviceAndUserRelationService.getRelationsByUser(userDto);
                    if (orgRelations != null && orgRelations.size() > 0){
                        boolean flag;
                        for (DeviceAndUserRelationDto orgRelation: orgRelations) {
                            flag = false;
                            for (DeviceAndUserRelationDto newRelation:relationDtos) {
                                if(orgRelation.deviceInfoDto.identificationCode.equals(newRelation.deviceInfoDto.identificationCode)){
                                    flag = true;
                                    break;
                                }
                            }
                            if(!flag){
                                deviceAndUserRelationService.removeRelation(orgRelation);
                            }
                        }
                    }

                    deviceAndUserRelationService.batchSave(relationDtos);
                }
            }
        }
        return userDto;
        return null;
    }

    @Override
    public void updateUserDeviceAndDeviceFeatureRelation(DeviceMasterObjInfoDto masterDto) {

    }

    protected UserDto fetchUserInfo(AccountDto accountDto, AniOAuthAccessToken accessToken) {
        if(accessToken != null) {
            return new UserDto(
                    accessToken.getAccessToken(),
                    accountDto.email,
                    accessToken.getExpiresIn(),
                    accountDto.accountId,
                    accessToken.getRefreshToken(),
                    accessToken.getScope(),
                    accountDto.screenName,
                    accessToken.getTokenType(),
                    System.currentTimeMillis()
            );
        } else {
            return userService.getUserByHashUserId(accountDto.accountId);
        }
    }
    public List<DeviceAndFeatureRelationDto> getRelation(
            List<DeviceMasterObjInfoDto> deviceMasterObjInfoDtoList) throws Exception {
        List<DeviceAndFeatureRelationDto> deviceAndFeatureDtos = new ArrayList<>();
        for (DeviceMasterObjInfoDto masterDto : deviceMasterObjInfoDtoList) {
            String masterType = deviceInfoGeneratorService.generatorDeviceType(masterDto.stubs);
            DeviceDto masterDeviceDto = new DeviceDto(
                    "default",
                    convert(masterDto.state),
                    masterType,
                    buildId(masterDto.objectId,-1),
                    masterDto.name,
                    masterDto.owner.accountId,
                    DeviceLogicState.OPEN,
                    deviceInfoGeneratorService.getDeviceLogoUrl(masterType)
            );
            if (masterDeviceDto.deviceState == null)
                continue;
            DeviceAndFeatureRelationDto masterDeviceAndFeatureDto =
                    new DeviceAndFeatureRelationDto(
                            masterDeviceDto,
                            buildDeviceFeatureByStubDto(masterDto.stubs)
                    );
            deviceAndFeatureDtos.add(masterDeviceAndFeatureDto);

            for (DeviceSlaveObjInfoDto objDto : masterDto.slaves) {
                String deviceType = deviceInfoGeneratorService.generatorDeviceType(objDto.stubs);
                DeviceDto deviceDto = new DeviceDto(
                        "default",
                        convert(objDto.state),
                        deviceType,
                        buildId(masterDto.objectId,objDto.objectSlaveId),
                        objDto.name,
                        masterDto.owner.accountId,
                        DeviceLogicState.OPEN,
                        deviceInfoGeneratorService.getDeviceLogoUrl(deviceType)
                );
                if(deviceDto.deviceState == null)
                    continue;
                DeviceAndFeatureRelationDto deviceAndFeatureDto =
                        new DeviceAndFeatureRelationDto(
                                deviceDto,
                                buildDeviceFeatureByStubDto(objDto.stubs)
                        );
                deviceAndFeatureDtos.add(deviceAndFeatureDto);
            }
        }
        return deviceAndFeatureDtos;
    }
    public static DeviceState convert(AniObjectState state) {
        if (state != null) {
            switch (state) {
                case ACTIVE:
                    return DeviceState.CONNECTED;
                case DISABLE:
                    return DeviceState.DISCONNECTED;
                case REMOVED:
                    return DeviceState.REMOVED;
            }
        }
        LOGGER.info("device state is "+ state);
        return null;
    }
    public String buildId(Long deviceMasterId, Integer slaveId) {
        return deviceMasterId + ":" + slaveId;
    }
    public List<FeatureDto> buildDeviceFeatureByStubDto(List<StubInfoDto> stubDtos) {
        List<FeatureDto> deviceFeatureDtoList = new ArrayList<>();
        if (stubDtos != null) {
            Set<StubIdentity> deviceStubSet = fetchDeviceStubSet(stubDtos);
            for (FeatureDto deviceFeatureDto : deviceFeatureDtos) {
                Set<StubIdentity> featureStubSet = fetchDeviceFeatureStubSet(deviceFeatureDto);
                Collection<StubIdentity> intersectionList = CollectionUtils.intersection(deviceStubSet, featureStubSet);
                if (featureStubSet.size() == intersectionList.size()) {
                    deviceFeatureDtoList.add(deviceFeatureDto);
                }
            }
        }
        return deviceFeatureDtoList;
    }
    public List<DeviceAndUserRelationDto> getDeviceAndUserRelations(List<DeviceAndFeatureRelationDto> deviceAndFeatureRelationDtos,UserDto userDto){
        List<DeviceAndUserRelationDto> relations = new ArrayList<>(deviceAndFeatureRelationDtos.size());
        for (DeviceAndFeatureRelationDto featureRelationDto : deviceAndFeatureRelationDtos) {
            DeviceAndUserRelationDto relationDto = new DeviceAndUserRelationDto(featureRelationDto.
                    deviceDto,userDto,"{}",featureRelationDto.deviceDto.name,"default");
            relations.add(relationDto);
        }
        return relations;
    }

    public Set<StubIdentity> fetchDeviceStubSet(List<StubInfoDto> stubDtos) {
        Set<StubIdentity> stubIdentitySet = new HashSet<>();
        for (StubInfoDto stubDto : stubDtos) {
            StubIdentity stubIdentity = new StubIdentity(
                    stubDto.stubId,
                    stubDto.group.groupId
            );
            stubIdentitySet.add(stubIdentity);
        }
        return stubIdentitySet;
    }
    public Set<StubIdentity> fetchDeviceFeatureStubSet(FeatureDto deviceFeatureDto) {
        Set<StubIdentity> stubIdentitySet = new HashSet<>();
        for (FeatureFunctionDto ffd : deviceFeatureDto.featureFunctionDtoList) {
            StubIdentity stubIdentity = new StubIdentity(
                    ffd.stubId,
                    ffd.groupId
            );
            stubIdentitySet.add(stubIdentity);
        }
        return stubIdentitySet;
    }
}
