package com.pms.pirate.repository.impl;

import com.pms.pirate.dto.PirateDto;
import com.pms.pirate.entity.Pirate;
import com.pms.pirate.exception.PirateNotFoundException;
import com.pms.pirate.mapper.PirateMapper;
import com.pms.pirate.repository.PirateRepository;
import com.pms.pirate.service.PirateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PirateServiceImpl implements PirateService {
    private PirateRepository pirateRepository;

    @Override
    public PirateDto createPirate(PirateDto pirateDto) {
        Pirate pirate = PirateMapper.mapToPirate(pirateDto);
        Pirate savedPirate = pirateRepository.save(pirate);
        return PirateMapper.mapToPirateDto(savedPirate);
    }

    @Override
    public PirateDto getPirateById(Long pirateId) {
        Pirate pirate = pirateRepository.findById(pirateId)
                .orElseThrow(() -> new PirateNotFoundException("Pirate with given id doesn't exists" + pirateId));
        return PirateMapper.mapToPirateDto(pirate);
    }

    @Override
    public List<PirateDto> getAllPirates() {
        List<Pirate> pirates = pirateRepository.findAll();
        return pirates.stream().map((pirate) -> PirateMapper.mapToPirateDto(pirate))
                .collect(Collectors.toList());
    }

    @Override
    public PirateDto updatePirate(Long pirateId, PirateDto updatedPirate) {
        Pirate pirate = pirateRepository.findById(pirateId).orElseThrow(
                () -> new PirateNotFoundException("Pirate with given id doesn't exists" + pirateId)
        );

        pirate.setName(updatedPirate.getName());
        pirate.setCrew(updatedPirate.getCrew());
        pirate.setRole(updatedPirate.getRole());
        pirate.setBounty(updatedPirate.getBounty());
        pirate.setEmail(updatedPirate.getEmail());

        Pirate updatedPirateObj = pirateRepository.save(pirate);

        return PirateMapper.mapToPirateDto(updatedPirateObj);
    }

    @Override
    public void deletePirate(Long pirateId) {
        Pirate pirate = pirateRepository.findById(pirateId)
                .orElseThrow(() -> new PirateNotFoundException("Pirate with given id doesn't exists" + pirateId));

        pirateRepository.deleteById(pirateId);
    }
}
