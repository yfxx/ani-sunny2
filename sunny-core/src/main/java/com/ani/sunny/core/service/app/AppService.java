package com.ani.sunny.core.service.app;


import com.ani.sunny.commons.dto.app.AppDto;
import com.ani.sunny.commons.dto.app.AppInfoDto;

import java.io.IOException;

/**
 * Created by zhaoyu on 15-6-27.
 */
public interface AppService {
    AppInfoDto getAniServiceInfo() throws IOException;
    void update(AppDto appDto) throws IOException;
}
