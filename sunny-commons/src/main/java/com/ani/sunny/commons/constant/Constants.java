package com.ani.sunny.commons.constant;

import com.ani.bus.service.commons.session.AniServiceSession;
import com.ani.sunny.commons.dto.app.AniServiceDto;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhaoyu on 15-6-27.
 */
public class Constants {
    private Constants() {}

//    public static Map<Integer,SunnyStub> SUNNY_STUB_MAPPINGS;
    public final static String CURRENT_USER = "@current_user";
    public final static String SUNNY_APP_REGISTER_NAME = "sunny-client";
    public final static String SUNNY_COOKIE_USER_NAME = "sunny_user";
    public final static int SUNNY_COOKIE_MAX_AGE = 7 * 24 * 3600;
    public final static String SUNNY_COOKIE_PATH = "sunny";

    public final static String SUNNY_SESSION_NAME = "sunny_session";

    public final static String SUNNY_DEVICE_DEFAULT_GROUP = "default";
    /**
     *  the device feature run as a strategy, use the strategy name to identify
     */
    public final static String STRATEGY_AS_DEVICE_FEATURE_RUN_NAME = "_PHONY_STRATEGY_";

    /**
     * the pattern type of the type trigger
     */
    public final static String TIME_TRIGGER_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public final static Long TOKEN_REFRESH_TIME_INTERVAL_IN_SECONDS = 60 * 60L;

    public static AniServiceDto aniServiceDto = null;
    /**
     * the different enter of sunny
     */
    public static String MODEL_NAME = "modelName";
    /**
     * the web socket session
     */
    public static AniServiceSession aniServiceSession;
    public static final ConcurrentHashMap<Long, List<Integer>> DEVICE_ID_RELATION_MAP = new ConcurrentHashMap<Long,List<Integer>>();
    public static final String DEVICE_SHARE_MESSAGE = "deviceShareMessage";
    public static final String DEVICE_UNSHARE_MESSAGE = "deviceUnShareMessage";
    public static final String DEVICE_BOUND_MESSAGE = "deviceBoundMessage";
    public static final String DEVICE_UNBOUND_MESSAGE = "deviceUnboundMessage";
}
