package com.sodamdadam.server.counselinginfo.service;

import com.sodamdadam.server.counselinginfo.dto.response.CounselingInfoDto;
import com.sodamdadam.server.counselinginfo.repository.CounselingInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CounselingInfoService {

    private final CounselingInfoRepository counselingInfoRepository;

    public CounselingInfoDto getPersonalCounselingInfo() {
        return counselingInfoRepository.getPersonalCounselingInfo();
    }

    public CounselingInfoDto getGroupCounselingInfo() {
        return counselingInfoRepository.getGroupCounselingInfo();
    }

    public CounselingInfoDto getPsychologicalCounselingInfo() {
        return counselingInfoRepository.getPsychologicalCounselingInfo();
    }

    public CounselingInfoDto getAdolescentsParentsCounselingInfo() {
        return counselingInfoRepository.getAdolescentsParentsCounselingInfo();
    }

    public CounselingInfoDto getCoupleCounselingInfo() {
        return counselingInfoRepository.getCoupleCounselingInfo();
    }
}
