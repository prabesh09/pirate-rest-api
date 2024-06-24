package com.pms.pirate.mapper;

import com.pms.pirate.dto.PirateDto;
import com.pms.pirate.entity.Pirate;

public class PirateMapper {
    public static PirateDto mapToPirateDto(Pirate pirate) {
        return new PirateDto(
                pirate.getId(),
                pirate.getName(),
                pirate.getCrew(),
                pirate.getRole(),
                pirate.getBounty(),
                pirate.getEmail()
        );
    }

    public static Pirate mapToPirate(PirateDto pirateDto) {
        return new Pirate(
                pirateDto.getId(),
                pirateDto.getName(),
                pirateDto.getCrew(),
                pirateDto.getRole(),
                pirateDto.getBounty(),
                pirateDto.getEmail()
        );
    }
}
