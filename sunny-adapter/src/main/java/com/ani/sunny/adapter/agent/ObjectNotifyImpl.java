package com.ani.sunny.adapter.agent;

import com.ani.agent.service.commons.object.enumeration.DeviceState;
import com.ani.agent.service.service.websocket.ObjectNotify;
import com.ani.bus.service.commons.dto.anidevice.DeviceMasterObjInfoDto;
import org.springframework.stereotype.Component;

/**
 * Created by wyf on 17-3-7.
 */
@Component("objectNotify")
public class ObjectNotifyImpl implements ObjectNotify{


    @Override
    public void deviceConectedNotify(Long objectId, String description) {
        updateObjectState(objectId, DeviceState.CONNECTED);
    }

    @Override
    public void deviceDisconnectedNotify(Long objectId, String description) {
        updateObjectState(objectId, DeviceState.DISCONNECTED);
    }

    private void updateObjectState(Long objectId, DeviceState state) {
    }

    @Override
    public void deviceBoundNotify(DeviceMasterObjInfoDto deviceMasterObjInfoDto, String description) {
    }

    @Override
    public void deviceUnBoundNotify(Long objectId, String description) {
    }

    @Override
    public void deviceSharedNotify(DeviceMasterObjInfoDto deviceMasterObjInfoDto, Long hashUserId, String description) {
    }

    @Override
    public void deviceUnsharedNotify(Long objectId, Long hashUserId, String description) {
    }

    @Override
    public void deviceUpdatedNotify(DeviceMasterObjInfoDto deviceMasterObjInfoDto) {
    }


}
