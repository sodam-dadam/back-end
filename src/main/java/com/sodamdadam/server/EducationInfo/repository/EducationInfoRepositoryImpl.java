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

    private EducationInfoDto createCounselorEducationInfo() {
        List<String> mainText = Arrays.asList("훈련과정에 있는 상담자들의", "성장에 도움이 되는 상담자 교육");
        String imgUrl1 = "../../../public/images/centerImg2.jpeg";
        String imgUrl2 = "../../../public/images/centerImg2.jpeg";
        List<String> subText1 = Arrays.asList("상담 전문가 양성을 위한 교육 프로그램으로", "슈퍼비전과 공개사례발표를 진행합니다.");
        List<String> subText2 = Arrays.asList("소담다담은 훈련과정에 있는 상담자들의", "개인적, 전문적 성장에 도움이 되는 교육 활동, 교육분석 등의",
                "체계적인 교육을 제공합니다.");

        return new EducationInfoDto(mainText, imgUrl1, imgUrl2, subText1, subText2);

    }

    private EducationInfoDto createBookReadingEducationInfo() {
        List<String> mainText = Arrays.asList("자신을 돌보는 북리딩 프로그램");
        String imgUrl1 = "../../../public/images/centerImg2.jpeg";
        String imgUrl2 = "../../../public/images/centerImg2.jpeg";
        List<String> subText1 = Arrays.asList("책을 통해 내면의 성장을 돕는", "소규모 세미나 형식으로 진행됩니다.");
        List<String> subText2 = Arrays.asList("소담다담은 자신을 돌보는 북리딩 프로그램을 통해", "책을 매개로 서로의 생각이나 느낌을 나누고 내면의 세계를",
                "깊고, 넒게 확장시켜 나가고자 합니다.");

        return new EducationInfoDto(mainText, imgUrl1, imgUrl2, subText1, subText2);

    }

    @Override
    public EducationInfoDto getWorkShopEducationInfo() {
        return createWorkShopEducationInfo();
    }

    @Override
    public EducationInfoDto getCounselorEducationInfo() {
        return createCounselorEducationInfo();
    }

    @Override
    public EducationInfoDto getBookReadingEducationInfo() {
        return createBookReadingEducationInfo();
    }
}
