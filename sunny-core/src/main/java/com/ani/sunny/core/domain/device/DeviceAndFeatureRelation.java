package com.ani.sunny.core.domain.device;

import com.ani.sunny.core.domain.AbstractDomain;
import com.ani.sunny.core.domain.feature.Feature;

/**
 * Created by wyf on 17-3-6.
 */
public class DeviceAndFeatureRelation extends AbstractDomain{
    private static final long serialVersionUID = -8458582653554072187L;

    public String deviceId;
    public Feature feature;
    public String curState;

    public DeviceAndFeatureRelation() {}

    public DeviceAndFeatureRelation(String deviceId, Feature feature, String curState) {
        this.deviceId = deviceId;
        this.feature = feature;
        this.curState = curState;
    }

    public void save(){}

    public void modify(){}

    public void remove(){}

    public void updataState(){}

    public void analyzeState(){}
}
