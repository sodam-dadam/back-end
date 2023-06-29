package com.sodamdadam.server.counselinginfo.controller;

import com.sodamdadam.server.counselinginfo.dto.response.CounselingInfoDto;
import com.sodamdadam.server.counselinginfo.repository.CounselingInfoRepository;
import com.sodamdadam.server.global.dto.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping ("/counselinginfo")
@RestController
public class CounselingInfoController {

    private final CounselingInfoRepository counselingInfoRepository;

    @GetMapping("/personal")
    public ResponseEntity<CommonResponse> getPersonalCounselingInfo() {
        CounselingInfoDto responseDto = counselingInfoRepository.getPersonalCounselingInfo();

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("PersonalCounselingInfo Response Data Success")
                        .data(responseDto)
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );
    }
}