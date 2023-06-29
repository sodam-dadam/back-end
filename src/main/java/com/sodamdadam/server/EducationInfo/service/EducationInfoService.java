package com.sodamdadam.server.EducationInfo.service;

import com.sodamdadam.server.EducationInfo.dto.response.EducationInfoDto;
import com.sodamdadam.server.EducationInfo.repository.EducationInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EducationInfoService {

    private final EducationInfoRepository educationInfoRepository;

    public EducationInfoDto getWorkShopEducationInfo() {
        return educationInfoRepository.getWorkShopEducationInfo();
    }

    public EducationInfoDto getCounselorEducationInfo() {
        return educationInfoRepository.getCounselorEducationInfo();
    }

    public EducationInfoDto getBookReadingEducationInfo() {
        return educationInfoRepository.getBookReadingEducationInfo();
    }
}
