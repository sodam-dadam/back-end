package com.sodamdadam.server.counselinginfo.controller;

import com.sodamdadam.server.counselinginfo.dto.response.CounselingInfoDto;
import com.sodamdadam.server.counselinginfo.service.CounselingInfoService;
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

    private final CounselingInfoService counselingInfoService;

    @GetMapping("/individuals")
    public ResponseEntity<CommonResponse> getPersonalCounselingInfo() {
        CounselingInfoDto responseDto = counselingInfoService.getPersonalCounselingInfo();

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("PersonalCounselingInfo Response Data Success")
                        .data(responseDto)
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );
    }

    @GetMapping("/groups")
    public ResponseEntity<CommonResponse> getGroupCounselingInfo() {
        CounselingInfoDto responseDto = counselingInfoService.getGroupCounselingInfo();

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("GroupCounselingInfo Response Data Success")
                        .data(responseDto)
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );
    }

    @GetMapping("/psychologicaltests")
    public ResponseEntity<CommonResponse> getPsychologicalCounselingInfo() {
        CounselingInfoDto responseDto = counselingInfoService.getPsychologicalCounselingInfo();

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("PsychologicalCounselingInfo Response Data Success")
                        .data(responseDto)
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );
    }

    @GetMapping("/adolescentsparents")
    public ResponseEntity<CommonResponse> getAdolescentsParentsCounselingInfo() {
        CounselingInfoDto responseDto = counselingInfoService.getAdolescentsParentsCounselingInfo();

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("AdolescentsParentsCounselingInfo Response Data Success")
                        .data(responseDto)
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );
    }

    @GetMapping("/couples")
    public ResponseEntity<CommonResponse> getCoupleCounselingInfo() {
        CounselingInfoDto responseDto = counselingInfoService.getCoupleCounselingInfo();

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("CoupleCounselingInfo Response Data Success")
                        .data(responseDto)
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );
    }
}
