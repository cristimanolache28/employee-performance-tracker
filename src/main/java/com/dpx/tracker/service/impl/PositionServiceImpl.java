package com.dpx.tracker.service.impl;

import com.dpx.tracker.constants.ErrorMessage;
import com.dpx.tracker.dto.position.PositionCreateDto;
import com.dpx.tracker.dto.position.PositionResponseDto;
import com.dpx.tracker.repository.PositionRepository;
import com.dpx.tracker.service.PositionService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }


    @Override
    public PositionResponseDto createPosition(PositionCreateDto dto) {
        Objects.requireNonNull(dto, ErrorMessage.POSITION_DTO_NULL);
        return null;
    }
}
