package com.sodamdadam.server.counselorinfo.controller;

import com.sodamdadam.server.counselorinfo.dto.response.CounselorInfoDto;
import com.sodamdadam.server.counselorinfo.service.CounselorInfoService;
import com.sodamdadam.server.global.dto.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/counselorsinfo")
@RestController
public class CounselorInfoController {

    private final CounselorInfoService counselorInfoService;

    @GetMapping("/1")
    public ResponseEntity<CommonResponse> getCounselorInfo() {
        CounselorInfoDto responseDto = counselorInfoService.getCounselorInfo();

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("CounselorInfo Response Data Success")
                        .data(responseDto)
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );
    }
}
