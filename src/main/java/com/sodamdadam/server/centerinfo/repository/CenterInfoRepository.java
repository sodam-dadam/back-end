package com.sodamdadam.server.centerinfo.repository;

import com.sodamdadam.server.centerinfo.dto.IntroductionDto;
import com.sodamdadam.server.centerinfo.dto.ReservationInfoDto;

public interface CenterInfoRepository {

    ReservationInfoDto getReservationInfo();

    IntroductionDto getIntroduction();

}
