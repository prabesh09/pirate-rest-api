package com.pms.pirate.repository;

import com.pms.pirate.entity.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PirateRepository extends JpaRepository<Pirate, Long> {
    
}
