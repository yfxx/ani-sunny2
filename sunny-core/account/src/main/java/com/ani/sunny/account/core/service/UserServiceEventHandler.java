package com.ani.sunny.account.core.service;


import com.ani.agent.service.service.AgentTemplate;
import com.ani.sunny.account.core.domain.User;
import com.ani.sunny.account.infrastructure.domain.UserDao;
import com.ani.sunny.account.infrastructure.service.UserPersistenceService;
import com.ani.sunny.commons.dto.user.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by wyf on 17-3-1.
 */
@Component
@Transactional
public class UserServiceEventHandler implements UserService {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceEventHandler.class);

    @Resource
    private UserPersistenceService userPersistenceService;
    @Resource
    private AgentTemplate agentTemplate;

    @Override
    public User saveUser(UserDto userDto) {
        User user = User.toUser(userDto);
        return user.save();
    }

    @Override
    public User modifyUser(UserDto userDto) {
        User user = User.toUser(userDto);
        return user.modify();
    }

    @Override
    public void removeUser(UserDto userDto) {
        User user = User.toUser(userDto);
        user.remove();
    }

    @Override
    public User getUserByHashUserId(Long hashUserId) {
        UserDao userDao = userPersistenceService.getUserByHashUserId(hashUserId);
        return User.toUser(userDao);
    }

    @Override
    public User getUserByEmail(String email) {
        UserDao userDao = userPersistenceService.getUserByEmail(email);
        return User.toUser(userDao);
    }

}
