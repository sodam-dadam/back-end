package com.sodamdadam.server.centerinfo.repository;

import com.sodamdadam.server.centerinfo.dto.CounselingTimeDto;
import com.sodamdadam.server.centerinfo.dto.ReservationDto;
import com.sodamdadam.server.centerinfo.dto.ReservationInfoDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CenterInfoRepositoryImpl implements CenterInfoRepository{

    public ReservationInfoDto createReservationInfo() {
        List<ReservationDto> reservationList = new ArrayList<>();
        List<CounselingTimeDto> counselingTimeList = new ArrayList<>();

        reservationList.add(new ReservationDto("../../../public/images/Reservation.png",1,"상담 예약","홈페이지 및 전화를 통해 상담일정 예약 – 최종일정 확인 – 예약 완료"));
        reservationList.add(new ReservationDto("../../../public/images/firstCounseling.png",2,"초기 상담","주 호소문제 확인, 심리상담/심리치료 과정 안내"));
        reservationList.add(new ReservationDto("../../../public/images/counselingTest.png",3,"심리검사(선택 사항)","심리검사를 통한 다차원적이고 객관적인 심리분석"));
        reservationList.add(new ReservationDto("../../../public/images/deepCounseling.png",4,"심층상담/치료","체계적이고 심층적인 심리상담/심리치료 진행"));
        reservationList.add(new ReservationDto("../../../public/images/counselingFinish.png",5,"상담/치료 종결","심리상담/치료 종결 및 사후관리 안내"));

        counselingTimeList.add(new CounselingTimeDto("개인상담","50분"));
        counselingTimeList.add(new CounselingTimeDto("부부/커플/가족 상담","70분"));
        counselingTimeList.add(new CounselingTimeDto("심리검사","종류에 따라 상이"));
        counselingTimeList.add(new CounselingTimeDto("집단상담","1회당 2시간"));

        ReservationInfoDto response = new ReservationInfoDto<>("상담예약 안내", reservationList, counselingTimeList);

        return response;
    }

    @Override
    public ReservationInfoDto getReservationInfo() {
        return createReservationInfo();
    }
}
