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

    private CounselingInfoDto createPsychologicalCounselingInfo() {
        List<String> mainText = Arrays.asList("검사를 통해 다양한 심리적 특성에 대해 ', '파악하고 이를 통해 자신의 스토리를 찾는 심리검사");
        String imgUrl1 = "../../../public/images/centerImg2.jpeg";
        String imgUrl2 = "../../../public/images/centerImg2.jpeg";
        List<String> subText1 = Arrays.asList("개인 맞춤형 심리검사를", "선정하여 심층적인 자기 이해를 돕습니다.");
        List<String> subText2 = Arrays.asList("소담다담은 검사를 통해 다양한 심리적", "특성에 대해 파악하고 이를 통해 자신의 스토리를 찾아드립니다.",
                "이를 통해 개인의 성향이나 향후 행동을 예측하는데", "도움을 얻을 수 있어 일상생활의 다양한 부분에서", "사용되고 있습니다.");

        return new CounselingInfoDto(mainText, imgUrl1, imgUrl2, subText1, subText2);
    }

    private CounselingInfoDto createAdolescentsParentsCounselingInfo() {
        List<String> mainText = Arrays.asList("부모와 자녀가 함께', '성장통을 극복하도록 돕는 상담");
        String imgUrl1 = "../../../public/images/centerImg2.jpeg";
        String imgUrl2 = "../../../public/images/centerImg2.jpeg";
        List<String> subText1 = Arrays.asList("청소년의 적응문제", "해결 및 부모역량강화를 도와드립니다.");
        List<String> subText2 = Arrays.asList("소담다담은 자녀의 특성을 이해하고,", "문제행동을 하는 자녀의 마음을 돌봐주고,",
                "문제 행동의 원인을 찾아 부모와 자녀가 함께", "성장통을 극복하도록 도와드립니다.");

        return new CounselingInfoDto(mainText, imgUrl1, imgUrl2, subText1, subText2);
    }

    private CounselingInfoDto createCoupleCounselingInfo() {
        List<String> mainText = Arrays.asList("관계의 근본적인', '해결책을 찾는 부부상담과 커플상담");
        String imgUrl1 = "../../../public/images/centerImg2.jpeg";
        String imgUrl2 = "../../../public/images/centerImg2.jpeg";
        List<String> subText1 = Arrays.asList("부부, 커플의 관계성 향상을 위한", "심리상담으로 관계문제, 심리적 문제를 파악하고", "근본적인 해결책을 찾아나가는 상담입니다.");
        List<String> subText2 = Arrays.asList("소담다담은 소중한 인연으로 만나 겪게 되는", "다양한 어려움을 슬기롭게 극복하고 서로에게 힘과 용기를",
                "주는 관계로 성장할 수 있도록 성찰할 시간을 제공합니다.");

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

    @Override
    public CounselingInfoDto getPsychologicalCounselingInfo() {
        return createPsychologicalCounselingInfo();
    }

    @Override
    public CounselingInfoDto getAdolescentsParentsCounselingInfo() {
        return createAdolescentsParentsCounselingInfo();
    }

    @Override
    public CounselingInfoDto getCoupleCounselingInfo() {
        return createCoupleCounselingInfo();
    }

}
