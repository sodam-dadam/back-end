package com.sodamdadam.server.centerinfo.service;

import com.sodamdadam.server.centerinfo.dto.ReservationInfoDto;
import com.sodamdadam.server.centerinfo.repository.CenterInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationInfoService {

    private final CenterInfoRepository centerInfoRepository;

    public ReservationInfoDto getReservationInfo() {
        return centerInfoRepository.getReservationInfo();
    }

}
