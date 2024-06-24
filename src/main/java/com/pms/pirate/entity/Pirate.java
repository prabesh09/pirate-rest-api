package com.pms.pirate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pirates")
public class Pirate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "crew")
    private String crew;

    @Column(name = "role")
    private String role;

    @Column(name = "bounty")
    private Long bounty;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
}
