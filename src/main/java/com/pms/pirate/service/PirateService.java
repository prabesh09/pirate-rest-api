package com.pms.pirate.service;

import com.pms.pirate.dto.PirateDto;

import java.util.List;

public interface PirateService {
    PirateDto createPirate(PirateDto pirateDto);

    PirateDto getPirateById(Long pirateId);

    List<PirateDto> getAllPirates();

    PirateDto updatePirate(Long pirateId, PirateDto updatedPirate);

    void deletePirate(Long pirateId);
}
