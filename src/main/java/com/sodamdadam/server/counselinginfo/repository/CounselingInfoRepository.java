package com.sodamdadam.server.counselinginfo.repository;

import com.sodamdadam.server.counselinginfo.dto.response.CounselingInfoDto;

public interface CounselingInfoRepository {

    CounselingInfoDto getPersonalCounselingInfo();

    CounselingInfoDto getGroupCounselingInfo();
}
