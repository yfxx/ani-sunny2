package com.ani.sunny.core.domain.device;

import com.ani.sunny.core.domain.AbstractDomain;
import com.ani.sunny.core.domain.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wyf on 17-3-6.
 */
public class DeviceAndUserRelation extends AbstractDomain {
    private static final long serialVersionUID = -2299657565471563732L;

    public Device device;
    public User user;
    public Map<String,String> recentParams;
    public String screenName;
    public String deviceGroup;

    public DeviceAndUserRelation(){}

    public DeviceAndUserRelation(Device device, User user, Map<String,String> recentParams, String screenName, String deviceGroup){
        this.device = device;
        this.user = user;
        this.recentParams = recentParams;
        this.screenName = screenName;
        this.deviceGroup = deviceGroup;
    }

    public void save(){

    }

    public void modify(){

    }

    public List<String> getParamPath(){
        List<String> paths = new ArrayList<>();
        return paths;
    }

    private Map<String,String> getRecentParams(String initParam){
        Map<String,String> recentParams = new HashMap<>();
        return recentParams;
    }

}
