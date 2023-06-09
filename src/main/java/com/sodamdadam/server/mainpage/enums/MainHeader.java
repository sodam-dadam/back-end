package com.sodamdadam.server.mainpage.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MainHeader {

    CENTER_INFO("/CenterInfo", "센터 안내", new String[]{"소담다담 소개", "상담예약 안내", "오시는 길"},
            "../../../public/images/centerInfoImg.png", "두사람이 손을 잡고 있는 따뜻한 이미지"),
    COUNSELOR_INFO("/CounselorInfo", "상담전문가 소개", new String[]{"상담심리전문가", "전임 상담원"},
            "../../../public/images/centerInfoImg.png", "두사람이 손을 잡고 있는 따뜻한 이미지"),
    COUNSELING("/Counseling", "심리상담", new String[]{"개인상담", "심리검사", "집단상담", "청소년 & 부모상담", "부부 & 커플상담"},
            "../../../public/images/centerInfoImg.png", "두사람이 손을 잡고 있는 따뜻한 이미지"),
    EDUCATION("/Education", "심리교육", new String[]{"특강 및 워크숍", "상담자 교육", "북리딩 세미나"},
            "../../../public/images/centerInfoImg.png", "두사람이 손을 잡고 있는 따뜻한 이미지"),
    NOTICE("/Notice", "공지 ・ 문의", new String[]{"교육/워크숍 공지", "이벤트", "문의"},
            "../../../public/images/centerInfoImg.png", "두사람이 손을 잡고 있는 따뜻한 이미지")
    ;

    private final String url;
    private final String listName;
    private final String[] listItem;
    private final String listImg;
    private final String listImgAlt;

}
