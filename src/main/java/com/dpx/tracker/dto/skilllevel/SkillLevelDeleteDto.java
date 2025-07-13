package com.dpx.tracker.dto.skilllevel;

import java.time.Instant;
import java.util.UUID;

public record SkillLevelDeleteDto(
        String message,
        UUID id,
        Instant timestamp
) {
}
