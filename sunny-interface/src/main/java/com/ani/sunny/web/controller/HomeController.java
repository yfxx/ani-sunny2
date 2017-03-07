package com.ani.sunny.web.controller;

import com.ani.agent.service.commons.oauth.dto.AniOAuthAccessToken;
import com.ani.agent.service.commons.oauth.dto.AuthorizationCodeParameter;
import com.ani.agent.service.service.AgentTemplate;
import com.ani.sunny.adapter.agent.oauth.OAuth2ParameterBuilder;
import com.ani.sunny.commons.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wyf on 17-3-7.
 */
@Controller
public class HomeController extends BaseController{
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Value("${servicebus.oauth.url}")
    private  String OAUTH_URL;
    @Value("${servicebus.logout.url}")
    private  String LOGOUT_URL;
    @Resource
    private AgentTemplate agentTemplate;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        LOGGER.info("redirect:"+OAUTH_URL);
        return "redirect:"+OAUTH_URL;
    }

    @RequestMapping(value ="/redirect")
    public String redirect(HttpServletRequest request, HttpServletResponse response, @RequestParam String code) {
        LOGGER.info("code is {}", code);
//        AuthorizationCodeParameter authorizationCodeParameter = OAuth2ParameterBuilder.buildForAccessToken(Constants.appInfoDto);
//        AniOAuthAccessToken oAuth2AccessToken = agentTemplate.getAniOAuthService().getOAuth2AccessToken(code, authorizationCodeParameter);
        return null;
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("redirect:"+LOGOUT_URL);
        return "redirect:"+LOGOUT_URL;
    }


}
