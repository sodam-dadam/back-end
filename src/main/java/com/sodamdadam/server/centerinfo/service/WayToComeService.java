package com.sodamdadam.server.centerinfo.service;

import com.sodamdadam.server.centerinfo.dto.WayToComeDto;
import com.sodamdadam.server.global.dto.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WayToComeService {

    private final WayToComeDto wayToComeDto;

    public WayToComeService() {
        this.wayToComeDto = new WayToComeDto();
    }

    public ResponseEntity<CommonResponse> watToComeData(){

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("WayToCome Response Data Success")
                        .data(wayToComeDto)
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );

    }
}
