package com.sodamdadam.server.EducationInfo.repository;

import com.sodamdadam.server.EducationInfo.dto.response.EducationInfoDto;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class EducationInfoRepositoryImpl implements EducationInfoRepository{

    private EducationInfoDto createWorkShopEducationInfo() {
        List<String> mainText = Arrays.asList("상담 및 치료에 대한 이론이나", "기법소개, 실습 기회등을 제공하는 특강 및 워크숍");
        String imgUrl1 = "../../../public/images/centerImg2.jpeg";
        String imgUrl2 = "../../../public/images/centerImg2.jpeg";
        List<String> subText1 = Arrays.asList("주제별 강연, 참여 활동 프로그램을 통해", "자기 돌봄 및 삶에 대해 폭넓은 조망 능력을", "증진시킬 수 있습니다.");
        List<String> subText2 = Arrays.asList("소담다담은 상담 및 치료에 대한 이론이나 기법 소개,", "실습 시회 등을 제공하는 워크샵을 통해 다양하고 질좋은",
                "교육과 실습 기회를 제공합니다.");

        return new EducationInfoDto(mainText, imgUrl1, imgUrl2, subText1, subText2);

    }

    @Override
    public EducationInfoDto getWorkShopEducationInfo() {
        return createWorkShopEducationInfo();
    }
}
