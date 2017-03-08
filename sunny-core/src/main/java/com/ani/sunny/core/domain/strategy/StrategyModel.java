package com.ani.sunny.core.domain.strategy;

import com.ani.sunny.core.domain.AbstractDomain;
import com.ani.sunny.core.domain.user.User;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.Date;
import java.util.List;

/**
 * Created by wyf on 17-3-6.
 */
@Configurable
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

    public StrategyModel(){}

    public StrategyModel(String strategyId, String strategyName,
                    String description, User owner,
                    Date startTime, String[] repeatWeek,
                    boolean isRepeat, boolean isScheduleNow,
                    List<DeviceFeatureInstance> deviceFeatureInstanceList) {
        this.strategyId = strategyId;
        this.strategyName = strategyName;
        this.description = description;
        this.owner = owner;
        this.startTime = startTime;
        this.repeatWeek = repeatWeek;
        this.isRepeat = isRepeat;
        this.isScheduleNow = isScheduleNow;
        this.deviceFeatureInstanceList = deviceFeatureInstanceList;
    }

    @Override
    public String toString() {
        return "Strategy{" +
                "description='" + description + '\'' +
                ", strategyName='" + strategyName + '\'' +
                '}';
    }

}
