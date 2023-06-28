package com.sodamdadam.server.counselorinfo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CounselorInfoDto<T> {

    private String infoText;
    private String lastText;
    private T career;

}
