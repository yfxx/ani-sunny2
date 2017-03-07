package com.ani.sunny.core.domain.user;

import com.ani.sunny.core.domain.AbstractDomain;

/**
 * Created by wyf on 17-3-6.
 */
public class User extends AbstractDomain {
    private static final long serialVersionUID = 8530790643065344396L;

    public Long hashUserId;
    public String email;
    public String screenName;

    public String accessToken;
    public String tokenType;
    public String refreshToken;
    public Long expiresIn;
    public String scope;
    public Long createTime;

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

}
