package com.sodamdadam.server.counselinginfo.repository;

import com.sodamdadam.server.counselinginfo.dto.response.PersonalCounselingInfoDto;

public interface CounselingInfoRepository {

    PersonalCounselingInfoDto getPersonalCounselingInfo();
}
