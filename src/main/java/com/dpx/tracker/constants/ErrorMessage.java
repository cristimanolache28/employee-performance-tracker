package com.dpx.tracker.constants;

public final class ErrorMessage {

    private ErrorMessage() {
        throw new UnsupportedOperationException("Utility class, do not instantiate");
    }

    public static final String ROLE_NOT_FOUND = "Role with id %s not found.";
    public static final String ROLE_LIST_EMPTY = "Roles list is empty.";
    public static final String ROLE_CREATE_DTO_NULL = "RoleCreateDto can not be null.";

    public static final String POSITION_DTO_NULL = "PositionCreateDto can not be null.";

    public static final String SKILL_LEVEL_STAGE_DTO_NULL = "SkillLevelStageDto is null.";
    public static final String SKILL_LEVEL_STAGE_ID_NULL = "SkillLevelStage with ID %s not found.";

    public static final String SKILL_LEVEL_ID_NULL = "SkillLevel with id %s not found.";
    public static final String SKILL_LEVEL_DTO_NULL = "SkillLevel can not be null.";
}
