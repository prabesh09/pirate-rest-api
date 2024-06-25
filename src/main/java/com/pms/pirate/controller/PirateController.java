package com.pms.pirate.controller;

import com.pms.pirate.dto.PirateDto;
import com.pms.pirate.service.PirateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/pirates")
public class PirateController {

    private PirateService pirateService;

    @PostMapping
    public ResponseEntity<PirateDto> createPirate(@RequestBody PirateDto pirateDto) {
        PirateDto savedPirate = pirateService.createPirate(pirateDto);
        return new ResponseEntity<>(savedPirate, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PirateDto> getPirateByID(@PathVariable("id") Long pirateId) {
        PirateDto pirateDto = pirateService.getPirateById(pirateId);
        return ResponseEntity.ok(pirateDto);
    }

    @GetMapping
    public ResponseEntity<List<PirateDto>> getAllPirates() {
        List<PirateDto> pirates = pirateService.getAllPirates();
        return ResponseEntity.ok(pirates);
    }

    @PutMapping("{id}")
    public ResponseEntity<PirateDto> updatePirate(@PathVariable("id") Long pirateId,
                                                  @RequestBody PirateDto updatedPirate) {
        PirateDto pirateDto = pirateService.updatePirate(pirateId, updatedPirate);
        return ResponseEntity.ok(pirateDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePirate(@PathVariable("id") Long pirateId) {
        pirateService.deletePirate(pirateId);
        return ResponseEntity.ok("Pirate deleted successfully");
    }
}
