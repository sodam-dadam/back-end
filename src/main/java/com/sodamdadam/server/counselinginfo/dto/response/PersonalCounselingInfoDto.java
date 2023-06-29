package com.sodamdadam.server.counselinginfo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PersonalCounselingInfoDto {

    private List<String> mainText;
    private String imgUrl1;
    private String imgUrl2;
    private List<String> subText1;
    private List<String> subText2;

}
