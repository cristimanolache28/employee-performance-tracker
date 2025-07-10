package com.dpx.tracker.constants;

public final class ErrorMessage {

    private ErrorMessage() {
        throw new UnsupportedOperationException("Utility class, do not instantiate");
    }

    public static final String ROLE_NOT_FOUND = "Role with id %s not found";
    public static final String ROLE_LIST_EMPTY = "Roles list is empty.";
    public static final String ROLE_CREATE_DTO_NULL = "RoleCreateDto can not be null";

    public static final String POSITION_CREATE_DTO_NULL = "PositionCreateDto can not be null";

    public static final String SLS_CREATE_DTO_NULL = "SkillLevelStageCreateDto can not be null";
}
