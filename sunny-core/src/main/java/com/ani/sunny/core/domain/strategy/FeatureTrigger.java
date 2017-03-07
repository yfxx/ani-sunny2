package com.ani.sunny.core.domain.strategy;

import com.ani.sunny.commons.enumeration.TriggerType;
import com.ani.sunny.core.domain.AbstractDomain;

/**
 * Created by wyf on 17-3-6.
 */
public class FeatureTrigger extends AbstractDomain{
    private static final long serialVersionUID = -706868344772718971L;

    public TriggerType triggerType;
    // Json String
    public String value;

    public FeatureTrigger() {
    }

    public FeatureTrigger(String value, TriggerType triggerType) {
        this.value = value;
        this.triggerType = triggerType;
    }
}
