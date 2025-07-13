package com.dpx.tracker.dto.skilllevelstages;

import java.time.Instant;
import java.util.UUID;

public record SkillLevelStageDeleteResponse(
        String message,
        UUID id,
        Instant timestamp
) {

}
