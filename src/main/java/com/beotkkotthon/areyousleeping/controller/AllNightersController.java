package com.beotkkotthon.areyousleeping.controller;

import com.beotkkotthon.areyousleeping.annotation.UserId;
import com.beotkkotthon.areyousleeping.dto.global.ResponseDto;
import com.beotkkotthon.areyousleeping.service.AllNightersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "AllNighters", description = "밤샘기록 관련 API")
@RequestMapping("/api/v1/all-nighters")
public class AllNightersController {
    private final AllNightersService allNightersService;
    @GetMapping("/summary")
    @Operation(summary = "월별 밤샘 기록 조회", description = "조회하고자 하는 년,월을 바탕으로 월별 밤샘 기록을 조회합니다.")
    public ResponseDto<?> readAllNighters(
            @UserId Long userId,
            @RequestParam(value = "year") int year,
            @RequestParam(value = "month") int month
    ) {
        return ResponseDto.ok(allNightersService.readAllNighters(userId, year, month));
    }
}
