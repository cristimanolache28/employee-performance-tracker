package com.dpx.tracker.mapper;

import com.dpx.tracker.dto.EmployeeLiteDto;
import com.dpx.tracker.entity.Employee;

public final class EmployeeMapper {

    private EmployeeMapper() {

    }

    public static EmployeeLiteDto toLiteDto(Employee employee) {
        if (employee == null) {
            return null;
        }

        String fullName = buildFullName(
          employee.getFirstName(),
          employee.getMiddleName(),
          employee.getLastName()
        );

        String position = employee.getPosition() != null
                ? employee.getPosition().getName() : null;

        return new EmployeeLiteDto(
                employee.getId(),
                fullName,
                position
        );

    }


    private static String buildFullName(String first, String middle, String last) {
        StringBuilder sb = new StringBuilder();
        sb.append(first).append(" ");
        sb.append(middle).append(" ");
        sb.append(last).append(" ");
        return sb.toString().trim();
    }

}
