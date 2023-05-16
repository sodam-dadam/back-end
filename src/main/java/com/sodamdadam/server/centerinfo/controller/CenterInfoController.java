package com.sodamdadam.server.centerinfo.controller;

import com.sodamdadam.server.centerinfo.service.WayToComeService;
import com.sodamdadam.server.global.dto.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/centerinfo")
@RestController
public class CenterInfoController {

    private final WayToComeService wayToComeService;

    @GetMapping("/waytocome")
    public ResponseEntity<CommonResponse> watToComeData(){
        return wayToComeService.watToComeData();
    }
}
