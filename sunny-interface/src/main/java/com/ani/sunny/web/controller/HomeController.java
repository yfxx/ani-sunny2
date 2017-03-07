package com.ani.sunny.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

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


}
