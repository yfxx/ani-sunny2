package com.ani.sunny.core.service.app;

import com.ani.sunny.commons.dto.app.AppDto;
import com.ani.sunny.commons.dto.app.AppInfoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * Created by wyf on 17-3-7.
 */
@Component("appService")
public class JsonAppServiceImpl implements AppService{
    private final static Logger LOGGER = LoggerFactory.getLogger(JsonAppServiceImpl.class);
    private final static String FILE_PATH = "properties/AppInfo.json";

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public AppInfoDto getAniServiceInfo() throws IOException {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(FILE_PATH);
        AppDto appDto = null;
        if (resource.exists()) {
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, Boolean.TRUE);
            appDto = objectMapper.readValue(resource.getURL(),AppDto.class);
        } else {
            LOGGER.error("service information file not exists.");
            throw new IOException("service information file not exists.");
        }
        return new AppInfoDto(appDto.aniServiceId, appDto.serviceName,appDto.clientSecret,appDto.webServerRedirectUri);
    }

    @Override
    public void update(AppDto appDto) throws IOException {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(FILE_PATH);
        File targetFile = resource.getFile();
        if(targetFile.exists()){
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, Boolean.TRUE);
            objectMapper.writeValue(targetFile,appDto);
        } else {
            LOGGER.error("service information file not exists.");
            throw new IOException("service information file not exists.");
        }
    }
}
