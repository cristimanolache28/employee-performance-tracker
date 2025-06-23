package com.dpx.tracker.dto;

import java.util.UUID;

public record EmployeeLiteDto (
    UUID id,
    String fullName,
    String position
) {

}
