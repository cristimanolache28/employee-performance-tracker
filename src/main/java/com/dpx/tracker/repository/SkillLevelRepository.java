package com.dpx.tracker.repository;

import com.dpx.tracker.entity.SkillLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkillLevelRepository extends JpaRepository<SkillLevel, UUID> {
}
