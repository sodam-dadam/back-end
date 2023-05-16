package com.sodamdadam.server.mainpage.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SubCategory {

//    심리 상담 카테고리
    CONSULTING_1("personalImg","개인 상담","스트레스 완화, 적응력 향상을 위한 1:1 성인상담"),
    CONSULTING_2("psychologicalTestImg","심리 검사","개인 맞춤형 심리검사를 선정하여 심층적 자기 이해"),
    CONSULTING_3("teenagerAndParentCounselingImg","청소년 & 부모상담","청소년의 적응문제 해결 및 부모역량강화"),
    CONSULTING_4("coupleCounselingImg","부부 & 커플상담","부부, 커플의 관계성 향상을 위한 심리상담"),
    CONSULTING_5("groupCounselingImg","집단 상담","공동의 주제에 대해 나누는 성장, 교육집단"),

//    심리 교육 카테고리
    EDUCATION_1("workShopImg","특강 및 워크샵","주제별 강연, 참여 활동 프로그램"),
    EDUCATION_2("supervisionImg","상담자 교육","상담 전문가 양성을 위한 교육 프로그램"),
    EDUCATION_3("bookReadingImg","북리딩 세미나","책을 통해 내면의 성장을 돕는 소규모 세미나"),
    ;

    private final String img;
    private final String title;
    private final String content;

}
