package com.sodamdadam.server.mainpage.controller;

import com.sodamdadam.server.global.dto.response.CommonResponse;
import com.sodamdadam.server.mainpage.dto.response.MainPageDataDto;
import com.sodamdadam.server.mainpage.service.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MainPageController {

    private final MainPageService mainPageService;

    @GetMapping("/")
    public ResponseEntity<CommonResponse> getMainPageData() {
        MainPageDataDto responseDto = mainPageService.getMainPageData();

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("MainPage Response Data Success")
                        .data(responseDto)
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );

    }
}
