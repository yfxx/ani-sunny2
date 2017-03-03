package com.ani.sunny.account.infrastructure.domain;

import com.ani.sunny.commons.share.persistence.AbstractEntity;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by zhaoyu on 15-6-8.
 */
@Entity
@Table(name = "t_user")
public class UserDao extends AbstractEntity {
    private static final long serialVersionUID = -1856228190263844653L;

    @Column(name = "hash_user_id", unique = true, nullable = false)
    public Long hashUserId;
    @Column(name = "email", unique = true, nullable = false, length = 50)
    public String email;
    @Column(name = "screen_name", unique = true, nullable = false, length = 100)
    public String screenName;
    @Column(name = "access_token", length = 100)
    public String accessToken;
    @Column(name = "token_type", length = 50)
    public String tokenType;
    @Column(name = "refresh_token", length = 100)
    public String refreshToken;
    @Column(name = "expires_in")
    public Long expiresIn;
    @Column(name = "scope")
    public String scope;
    @CreatedDate
    @Column(name = "create_time")
    public Long createTime;

    public UserDao() {
    }

    public UserDao(String email, Long hashUserId, String screenName) {
        this.email = email;
        this.hashUserId = hashUserId;
        this.screenName = screenName;
    }

    public UserDao(String accessToken, String email, Long expiresIn, Long hashUserId,
                   String refreshToken, String scope, String screenName, String tokenType, Long createTime) {
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
}
