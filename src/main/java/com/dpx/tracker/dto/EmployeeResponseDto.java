package com.dpx.tracker.dto;

import com.dpx.tracker.dto.user.UserResponseDto;
import com.dpx.tracker.enums.EducationalStage;
import com.dpx.tracker.enums.Gender;
import com.dpx.tracker.enums.GeneralLevel;

import java.time.LocalDate;
import java.util.UUID;

public record EmployeeResponseDto (
        UUID id,
        String firstName,
        String middleName,
        String lastName,
        GeneralLevel generalLevel,
        String address,
        Gender gender,
        EducationalStage educationalStage,
        LocalDate birthDate,
        LocalDate startWorkDate
) {
}
