package com.sodamdadam.server.EducationInfo.controller;

import com.sodamdadam.server.EducationInfo.dto.response.EducationInfoDto;
import com.sodamdadam.server.EducationInfo.service.EducationInfoService;
import com.sodamdadam.server.global.dto.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/educations")
@RestController
public class EducationInfoController {

    private final EducationInfoService educationInfoService;

    @GetMapping("/workshops")
    public ResponseEntity<CommonResponse> getWorkShopEducationInfo() {
        EducationInfoDto responseDto = educationInfoService.getWorkShopEducationInfo();

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("WorkShopEducationInfo Response Data Success")
                        .data(responseDto)
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );
    }

    @GetMapping("/counselors")
    public ResponseEntity<CommonResponse> getCounselorEducationInfo() {
        EducationInfoDto responseDto = educationInfoService.getCounselorEducationInfo();

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("CounselorEducationInfo Response Data Success")
                        .data(responseDto)
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );
    }

    @GetMapping("/bookreading")
    public ResponseEntity<CommonResponse> getBookReadingEducationInfo() {
        EducationInfoDto responseDto = educationInfoService.getBookReadingEducationInfo();

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("BookReadingEducationInfo Response Data Success")
                        .data(responseDto)
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );
    }
}
