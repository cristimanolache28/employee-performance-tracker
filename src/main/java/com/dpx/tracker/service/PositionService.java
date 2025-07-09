package com.dpx.tracker.service;

import com.dpx.tracker.dto.position.PositionCreateDto;
import com.dpx.tracker.dto.position.PositionResponseDto;

public interface PositionService {

    PositionResponseDto createPosition(PositionCreateDto dto);
}
