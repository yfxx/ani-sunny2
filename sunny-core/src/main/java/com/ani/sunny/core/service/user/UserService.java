package com.ani.sunny.core.service.user;

import com.ani.sunny.commons.dto.user.UserDto;
import com.ani.sunny.commons.dto.user.UserInfoDto;

/**
 * Created by wyf on 17-3-6.
 */
public interface UserService {
    public UserDto saveUser(UserDto userDao);

    public UserDto modifyUser(UserDto userDao);

    public void removeUser(UserDto userDao);

    public UserDto getUserByHashUserId(Long hashUserId);

    public UserDto getUserByEmail(String email);

    public UserInfoDto getUserInfoByHashUserId(Long hashUserId);

    public UserDto refreshUserToken(Long hashUserId);
}
