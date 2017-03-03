package com.ani.sunny.account.infrastructure.service;

import com.ani.sunny.account.infrastructure.domain.UserDao;
import org.springframework.stereotype.Service;

/**
 * Created by zhaoyu on 15-6-14.
 */
@Service
public interface UserPersistenceService {
    public UserDao saveUser(UserDao userDao);
    public UserDao modifyUser(UserDao userDao);
    public void deleteUser(UserDao userDao);

    public UserDao getUserByHashUserId(Long hashUserId);
    public UserDao getUserByEmail(String email);
}
