package com.bfsi.rulesservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bfsi.rulesservice.entity.RuleTrigger;

public interface RuleTriggerRepository extends JpaRepository<RuleTrigger, Integer>{
    
}
