package com.ani.sunny.account.core.facade;

import com.ani.sunny.commons.dto.user.UserDto;

/**
 * Created by wyf on 17-3-1.
 */
public interface UserServiceFacade {
    public UserDto saveUser(UserDto userDto);
    public UserDto modifyUser(UserDto userDto);
    public void removeUser(UserDto userDto);

    public UserDto getUserByHashUserId(Long hashUserId);
    public UserDto getUserByEmail(String email);
    public UserDto refreshUserToken(Long hashUserId);
}
