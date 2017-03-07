package com.ani.sunny.core.domain.strategy;

import com.ani.sunny.core.domain.strategy.enumeration.ScheduleState;
import com.ani.sunny.core.domain.strategy.enumeration.StrategyAction;

import java.io.Serializable;

/**
 * Created by wyf on 17-3-6.
 */
public class StrategyInstance implements Serializable{
    private static final long serialVersionUID = -6312836341514335979L;

    public StrategyModel strategyModel;

    public String StrategyInstanceId;

    public ScheduleState state;
    public Integer stage;
    public StrategyAction action;
    public Long timeStamp;

}
