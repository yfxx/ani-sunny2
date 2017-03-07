package com.ani.sunny.commons.dto.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @autor zhaoyu
 * @date 16-4-6
 * @since JDK 1.7
 */
public class AniServiceEntranceDto {
    public Long entranceId;
    public String entranceName;
    public String entranceUrl;
    public String logoPath;
    public Set<String> tagSet;
    public String description;

    public AniServiceEntranceDto() {
    }

    public AniServiceEntranceDto(String entranceName, String entranceUrl,
                                 String logoPath, Set<String> tagSet,
                                 String description) {
        this.entranceName = entranceName;
        this.entranceUrl = entranceUrl;
        this.logoPath = logoPath;
        this.tagSet = tagSet;
        this.description = description;
    }

    public AniServiceEntranceDto(Long entranceId, String entranceName,
                                 String entranceUrl, String logoPath,
                                 Set<String> tagSet, String description) {
        this.entranceId = entranceId;
        this.entranceName = entranceName;
        this.entranceUrl = entranceUrl;
        this.logoPath = logoPath;
        this.tagSet = tagSet;
        this.description = description;
    }

    public static List<com.ani.bus.service.commons.dto.aniservice.AniServiceEntranceDto> fromCommonsToLocal(List<AniServiceEntranceDto> entranceDtoList)
    {
        if (entranceDtoList == null){
            return null;
        }
        List<com.ani.bus.service.commons.dto.aniservice.AniServiceEntranceDto> commonsEntranceList = new ArrayList<>();
        for (AniServiceEntranceDto entranceDto: entranceDtoList) {
            commonsEntranceList.add(new com.ani.bus.service.commons.dto.aniservice.AniServiceEntranceDto(
                    entranceDto.entranceId,
                    entranceDto.entranceName,
                    entranceDto.entranceUrl,
                    entranceDto.logoPath,
                    entranceDto.tagSet,
                    entranceDto.description)
            );
        }
        return commonsEntranceList;
    }

    @Override
    public String toString() {
        return "AniServiceEntranceDto{" +
                "entranceId=" + entranceId +
                ", entranceName='" + entranceName + '\'' +
                ", entranceUrl='" + entranceUrl + '\'' +
                ", logoPath='" + logoPath + '\'' +
                ", tagSet=" + tagSet +
                ", description='" + description + '\'' +
                '}';
    }
}
