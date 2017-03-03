package com.ani.sunny.account.core.facade;

import com.ani.agent.service.commons.oauth.dto.AniOAuthAccessToken;
import com.ani.agent.service.commons.oauth.dto.AuthorizationCodeParameter;
import com.ani.sunny.account.core.domain.User;
import com.ani.sunny.account.core.service.UserService;
import com.ani.sunny.commons.dto.user.UserDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by wyf on 17-3-1.
 */
@Component(value = "userServiceFacade")
public class UserServiceFacadeImpl implements UserServiceFacade {

    @Resource
    private UserService userService;
    @Override
    public UserDto saveUser(UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @Override
    public UserDto modifyUser(UserDto userDto) {
        return null;
    }

    @Override
    public void removeUser(UserDto userDto) {

    }

    @Override
    public UserDto getUserByHashUserId(Long hashUserId) {
        return null;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return null;
    }

    @Override
    public UserDto refreshUserToken(Long hashUserId) {
        UserDto userDto = getUserByHashUserId(hashUserId);

        Long currentTimeStamp = System.currentTimeMillis();
        if (userDto.expiresIn - (currentTimeStamp - userDto.createTime) / 1000 < Constants.TOKEN_REFRESH_TIME_INTERVAL_IN_SECONDS) {
            LOGGER.info("refresh user token.");
            AuthorizationCodeParameter authorizationCodeParameter = OAuth2ParameterBuilder.buildForRefreshToken(Constants.aniServiceDto);
            AniOAuthAccessToken accessToken = agentTemplate.getAniOAuthService()
                    .refreshAccessToken(userDto.refreshToken, authorizationCodeParameter);
            LOGGER.info("refresh token {}.", accessToken);

            userDto.accessToken = accessToken.getAccessToken();
            userDto.tokenType = accessToken.getTokenType();
            userDto.refreshToken = accessToken.getRefreshToken();
            userDto.expiresIn = accessToken.getExpiresIn();
            userDto.scope = accessToken.getScope();

            userDto = modifyUser(userDto);
        }
        return userDto;
    }
}
