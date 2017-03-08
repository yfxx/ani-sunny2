package com.ani.sunny.core.service.device;

import com.ani.octopus.commons.stub.dto.StubInfoDto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by lihui on 17-3-7.
 */
public abstract class DeviceInfoGeneratorService {
    protected static Map<String, Set<StubIdentity>> deviceTypeRule;  // key is type, value set is stub set
    protected static Map<String, String> deviceLogoUrls; //key is type, value is logo url

    public abstract void initDeviceTypeGeneratorRule();
    public abstract String generatorDeviceType(List<StubInfoDto> stubs);
    public abstract void initDeviceLogoUrl();
    public abstract String getDeviceLogoUrl(String deviceType);
}

