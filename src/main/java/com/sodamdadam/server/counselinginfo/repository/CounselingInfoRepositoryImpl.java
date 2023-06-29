package com.sodamdadam.server.counselinginfo.repository;

import com.sodamdadam.server.counselinginfo.dto.response.CounselingInfoDto;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CounselingInfoRepositoryImpl implements CounselingInfoRepository{

    private CounselingInfoDto createPersonalCounselingInfo() {
        List<String> mainText = Arrays.asList("개인문제의 근원을 찾고", "지지와 공감 속에 함께 해결방향을 찾는 상담");
        String imgUrl1 = "../../../public/images/centerImg2.jpeg";
        String imgUrl2 = "../../../public/images/centerImg2.jpeg";
        List<String> subText1 = Arrays.asList("스트레스 완화, 적응력 향상을 위한", "1:1 성인 상담으로 다양한", "삶의 이슈와 정서를 다룹니다.");
        List<String> subText2 = Arrays.asList("삶의 고비마다 혼자서 감당하기 어려운 문제가 있고,", "때로는 심리적 고통을 겪기도 합니다.",
                "소담다담은 자신의 주관적인 느낌이나 생각을", "스스로 탐색하고 이해해나가는 과정을 함께 하겠습니다.");

        return new CounselingInfoDto(mainText, imgUrl1, imgUrl2, subText1, subText2);
    }

    private CounselingInfoDto createGroupCounselingInfo() {
        List<String> mainText = Arrays.asList("집단의 역동을 활용하여', '개인관계, 대인관계를 돕는 집단상담");
        String imgUrl1 = "../../../public/images/centerImg2.jpeg";
        String imgUrl2 = "../../../public/images/centerImg2.jpeg";
        List<String> subText1 = Arrays.asList("공동의 주제에 대해 나누는 성장,", "교육집단으로 서로의 경험과 지혜를", "나누는 시간을 갖습니다.");
        List<String> subText2 = Arrays.asList("소담다담은 집단의 역동을 활용하여 자기 이해를 돕고,", "대인관계에서의 불편함이나 소외감,",
                "갈등 요소들을 다루고 해결해감으로써", "개인의 성장을 이끌고 있습니다.");

        return new CounselingInfoDto(mainText, imgUrl1, imgUrl2, subText1, subText2);
    }

    @Override
    public CounselingInfoDto getPersonalCounselingInfo() {
        return createPersonalCounselingInfo();
    }

    @Override
    public CounselingInfoDto getGroupCounselingInfo() {
        return createGroupCounselingInfo();
    }

}
