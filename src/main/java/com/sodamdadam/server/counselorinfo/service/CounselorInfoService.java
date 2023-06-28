package com.sodamdadam.server.counselorinfo.service;

import com.sodamdadam.server.counselorinfo.dto.response.CounselorInfoDto;
import com.sodamdadam.server.counselorinfo.repository.CounselorInfoRepository;
import com.sodamdadam.server.global.dto.response.CommonResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CounselorInfoService {

    private final CounselorInfoRepository counselorInfoRepository;

    public CounselorInfoDto getCounselorInfo() {
        return counselorInfoRepository.getCounselorInfo();
    }

}
