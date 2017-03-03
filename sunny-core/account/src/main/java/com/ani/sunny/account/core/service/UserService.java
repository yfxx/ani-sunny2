package com.ani.sunny.account.core.service;


import com.ani.sunny.account.core.domain.User;
import com.ani.sunny.commons.dto.user.UserDto;
import org.springframework.stereotype.Service;

/**
 * Created by zhaoyu on 15-6-12.
 */
@Service
public interface UserService {
    public User saveUser(UserDto userDto);
    public User modifyUser(UserDto userDto);
    public void removeUser(UserDto userDto);

    public User getUserByHashUserId(Long hashUserId);
    public User getUserByEmail(String email);
}
