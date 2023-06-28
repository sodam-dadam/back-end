package com.sodamdadam.server.centerinfo.service;

import com.sodamdadam.server.centerinfo.dto.WayToComeDto;
import com.sodamdadam.server.global.dto.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WayToComeService {

    public WayToComeDto getWayToComeDto() {
        return new WayToComeDto();
    }

}
