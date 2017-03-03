package com.ani.sunny.account.core.domain;

import com.ani.sunny.account.infrastructure.domain.UserDao;
import com.ani.sunny.account.infrastructure.service.UserPersistenceService;
import com.ani.sunny.commons.dto.user.UserDto;
import com.ani.sunny.commons.share.domain.AbstractDomain;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * Created by wyf on 17-3-1.
 */
@Configurable
public class User extends AbstractDomain {
    private static final long serialVersionUID = -3291503820309014053L;

    public Long hashUserId;
    public String email;
    public String screenName;

    public String accessToken;
    public String tokenType;
    public String refreshToken;
    public Long expiresIn;
    public String scope;
    public Long createTime;

    @Resource
    transient UserPersistenceService userPersistenceService;

    public User() {
    }

    public User(String accessToken, String email,
                Long expiresIn, Long hashUserId, String refreshToken,
                String scope, String screenName, String tokenType, Long createTime) {
        this.accessToken = accessToken;
        this.email = email;
        this.expiresIn = expiresIn;
        this.hashUserId = hashUserId;
        this.refreshToken = refreshToken;
        this.scope = scope;
        this.screenName = screenName;
        this.tokenType = tokenType;
        this.createTime = createTime;
    }

    public void save() {
        userPersistenceService.saveUser(toDao());
    }

    public User modify() {
        Assert.notNull(this.hashUserId);
        UserDao userDao = toDao();
        userDao = userPersistenceService.modifyUser(userDao);
        return fromDao(userDao);
    }

    public void remove() {
        UserDao userDao = userPersistenceService.getUserByHashUserId(this.hashUserId);
        if (userDao == null) {
            throw new EmptyResultDataAccessException(1);
        }
        userPersistenceService.deleteUser(userDao);
    }

    public void initfromDao(UserDao userDao) {
        this.accessToken = userDao.accessToken;
        this.email = userDao.email;
        this.expiresIn = userDao.expiresIn;
        this.hashUserId = userDao.hashUserId;
        this.refreshToken = userDao.refreshToken;
        this.scope = userDao.scope;
        this.screenName = userDao.screenName;
        this.tokenType = userDao.tokenType;
        this.createTime = userDao.createTime;
    }

    public UserDao toDao() {
        UserDao userDao = new UserDao(
                this.accessToken,
                this.email,
                this.expiresIn,
                this.hashUserId,
                this.refreshToken,
                this.scope,
                this.screenName,
                this.tokenType,
                this.createTime);
        return userDao;
    }

    public static User fromDto(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        return new User(
                userDto.accessToken,
                userDto.email,
                userDto.expiresIn,
                userDto.hashUserId,
                userDto.refreshToken,
                userDto.scope,
                userDto.screenName,
                userDto.tokenType,
                userDto.createTime
        );
    }

    public UserDto toDto() {
        return new UserDto(
                this.accessToken,
                this.email,
                this.expiresIn,
                this.hashUserId,
                this.refreshToken,
                this.scope,
                this.screenName,
                this.tokenType,
                this.createTime
        );
    }
}
