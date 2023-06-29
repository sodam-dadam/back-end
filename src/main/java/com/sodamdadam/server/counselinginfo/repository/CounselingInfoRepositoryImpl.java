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

    @Override
    public CounselingInfoDto getPersonalCounselingInfo() {
        return createPersonalCounselingInfo();
    }

}
