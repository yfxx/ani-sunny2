package com.ani.sunny.core.domain.strategy;

import com.ani.sunny.core.domain.AbstractDomain;
import com.ani.sunny.core.domain.user.User;

import java.util.Date;
import java.util.List;

/**
 * Created by wyf on 17-3-6.
 */
public class StrategyModel extends AbstractDomain {
    private static final long serialVersionUID = 7079048409075935101L;

    public String strategyId;
    public String strategyName;
    public String description;
    public Date startTime;
    public boolean isScheduleNow;
    public boolean isRepeat;
    public String[] repeatWeek;
    public User owner;
    public List<DeviceFeatureInstance> deviceFeatureInstanceList;
}
