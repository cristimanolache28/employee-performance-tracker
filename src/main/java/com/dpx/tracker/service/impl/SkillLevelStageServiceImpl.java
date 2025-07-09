package com.dpx.tracker.service.impl;

import com.dpx.tracker.repository.SkillLevelStageRepository;
import org.springframework.stereotype.Service;

@Service
public class SkillLevelStageServiceImpl {

    private SkillLevelStageRepository slsRepository;

    public SkillLevelStageServiceImpl(SkillLevelStageRepository slsRepository) {
        this.slsRepository = slsRepository;
    }

}
