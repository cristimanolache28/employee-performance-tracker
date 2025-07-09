package com.dpx.tracker.repository;

import com.dpx.tracker.entity.SkillLevelStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkillLevelStageRepository extends JpaRepository<SkillLevelStage, UUID> {
}
