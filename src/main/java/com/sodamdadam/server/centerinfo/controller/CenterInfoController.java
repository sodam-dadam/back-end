package com.sodamdadam.server.centerinfo.controller;

import com.sodamdadam.server.centerinfo.dto.IntroductionDto;
import com.sodamdadam.server.centerinfo.dto.ReservationInfoDto;
import com.sodamdadam.server.centerinfo.dto.WayToComeDto;
import com.sodamdadam.server.centerinfo.service.IntroductionService;
import com.sodamdadam.server.centerinfo.service.ReservationInfoService;
import com.sodamdadam.server.centerinfo.service.WayToComeService;
import com.sodamdadam.server.global.dto.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/centerinfo")
@RestController
public class CenterInfoController {

    private final WayToComeService wayToComeService;
    private final IntroductionService introductionService;
    private final ReservationInfoService reservationInfoService;

    @GetMapping("/waytocome")
    public ResponseEntity<CommonResponse> watToComeData() {
        WayToComeDto responseDto = wayToComeService.getWayToComeDto();

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("WayToCome Response Data Success")
                        .data(responseDto)
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );
    }

    @GetMapping("/introduction")
    public ResponseEntity<CommonResponse> introductionData() {
        IntroductionDto responseDto = introductionService.getIntroduction();

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("Introduction Response Data Success")
                        .data(responseDto)
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );
    }

    @GetMapping("/reservation")
    public ResponseEntity<CommonResponse> reservationData() {
        ReservationInfoDto responseDto = reservationInfoService.getReservationInfo();

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("ReservationInfo Response Data Success")
                        .data(responseDto)
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );
    }
}
