package com.pms.pirate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PirateDto {
    private Long id;
    private String name;
    private String crew;
    private String role;
    private Long bounty;
    private String email;
}
