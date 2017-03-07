package com.ani.sunny.adapter.agent;

import com.ani.agent.service.service.websocket.ClientInvokable;
import com.ani.bus.service.commons.dto.anistub.AniStub;
import com.ani.octopus.commons.stub.dto.StubArgumentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import java.io.IOException;
import java.util.List;

/**
 * Created by wyf on 17-3-7.
 */
@Component
public class ClientInvokerImpl implements ClientInvokable {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientInvokerImpl.class);

    @Override
    public List<StubArgumentDto> invokeAniObjectSync(AniStub stub) throws IOException, EncodeException {
        return null;
    }

    @Override
    public void sessionOnClose(String s, CloseReason closeReason) {
        // TODO
    }

    @Override
    public void sessionOnError(String s, Throwable throwable) {
        // TODO
    }
}
