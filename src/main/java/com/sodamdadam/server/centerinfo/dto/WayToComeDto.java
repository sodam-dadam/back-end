package com.sodamdadam.server.centerinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WayToComeDto {
    private final String title;
    private final String wayToComeName;
    private final String wayToComeImg;
    private final String wayToComeFirstLocation;
    private final String wayToComeSecondLocation;
    private final String parkingInfoName;
    private final String parkingInfoContent;
    private final String callName;
    private final String callImg;
    private final String callContent;
    private final String infomationUseName;
    private final String infomationImg;
    private final String reservationImg;
    private final String reservationName;
    private final String internetImg;
    private  final String internetName;

    public WayToComeDto() {
        this.title = "경기도 수원시 팔달구 인계동 940-18";
        this.wayToComeName = "오시는 길";
        this.wayToComeImg = "../../../public/images/wayToCome.png";
        this.wayToComeFirstLocation = "MJ아이티밸리 9층 906호";
        this.wayToComeSecondLocation = "동수원 사거리 라마다 호텔과 은혜와 진리 교회 사이";
        this.parkingInfoName = "주차정보";
        this.parkingInfoContent = "지하 3층까지 가능, 주차비는 본 기관에서 부담합니다.";
        this.callName = "전화 번호";
        this.callImg = "../../../public/images/call.png";
        this.callContent = "010-2331-4058";
        this.infomationUseName = "이용 안내";
        this.infomationImg = "../../../public/images/InformationUse.png";
        this.reservationImg = "../../../public/images/reserve.png";
        this.reservationName = "예약";
        this.internetImg = "../../../public/images/wifi.png";
        this.internetName = "무선 인터넷";
    }
}
