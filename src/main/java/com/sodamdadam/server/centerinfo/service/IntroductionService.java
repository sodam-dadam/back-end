package com.sodamdadam.server.centerinfo.service;

import com.sodamdadam.server.centerinfo.dto.IntroductionDto;
import com.sodamdadam.server.centerinfo.repository.CenterInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class IntroductionService {

    private final CenterInfoRepository centerInfoRepository;

    public IntroductionDto getIntroduction() {
        return centerInfoRepository.getIntroduction();
    }

}
