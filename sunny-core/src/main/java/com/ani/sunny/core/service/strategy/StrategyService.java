package com.ani.sunny.core.service.strategy;

import com.ani.sunny.commons.dto.strategy.StrategyInfoDto;
import com.ani.sunny.commons.dto.strategy.StrategyInitDto;
import com.ani.sunny.commons.dto.strategy.StrategyModelInfoDto;
import com.ani.sunny.core.domain.strategy.StrategyInstance;
import com.ani.sunny.core.domain.strategy.enumeration.StrategyAction;

import java.util.List;

/**
 * Created by wyf on 17-3-6.
 */
public interface StrategyService {
    void saveStrategyModel(StrategyInitDto strategyInitDto);

    void saveStrategyInstance(StrategyInfoDto strategyInfoDto);

    void operateStrategy(String strategyId, StrategyAction action);

    void modifyStrategyModel(StrategyModelInfoDto strategyModelInfoDto);

    void removeStrategyModel(Long hashUserId, String startegyId);

    void removeStrategyInstance(Long hashUserId, String stategyInstanceId);

    StrategyModelInfoDto getStrategyModelById(String strategyId);

    StrategyInfoDto getStrategyInfoDtoById(String strategyInstanceId);

    List<StrategyModelInfoDto> getStrategyModelByUser(Long hashUserId);

    List<StrategyInfoDto> getStrategyInstanceByUser(Long hashUserId);

    List<StrategyInfoDto> getStrategyInstanceByUser(Long hashUserId, int page, int number);

    int getCountByHashUserId(Long hashUserId);

    List<StrategyInstance> getRunningStrategy();
}
