package com.dpx.tracker.mapper;

import com.dpx.tracker.dto.position.PositionCreateDto;
import com.dpx.tracker.dto.position.PositionResponseDto;
import com.dpx.tracker.entity.Department;
import com.dpx.tracker.entity.Position;
import com.dpx.tracker.repository.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;

public final class PositionMapper {

    public PositionMapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static Position toEntity(PositionCreateDto dto, DepartmentRepository departmentRepository) {
        if (dto == null) {
            return null;
        }

        Department department = departmentRepository.findById(dto.departmentId())
                .orElseThrow(() -> new EntityNotFoundException("Department not found " + dto.departmentId()));

        Position position = new Position();
        position.setName(dto.name());
        position.setDescription(dto.description());
        position.setDepartment(department);
        return position;
    }

    public static PositionResponseDto toDto(Position position) {
        if (position == null) {
            return null;
        }

        return new PositionResponseDto(
                position.getId(),
                position.getName(),
                position.getDescription(),
                position.getDepartment()
        );
    }

}
