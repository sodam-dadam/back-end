package com.sodamdadam.server.centerinfo.repository;

import com.sodamdadam.server.centerinfo.dto.CounselingTimeDto;
import com.sodamdadam.server.centerinfo.dto.IntroductionDto;
import com.sodamdadam.server.centerinfo.dto.ReservationDto;
import com.sodamdadam.server.centerinfo.dto.ReservationInfoDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
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

    public IntroductionDto createIntroduction() {
        return new IntroductionDto("소담다담 소개",
                "소담다담 심리상담센터는,",
                "../../../public/images/sodaInfoImg.jpg",
                "초록색 나뭇잎 이미지",
                Arrays.asList(
                        "삶을 살아가며 만나는 수많은 경험과 관계 속에서 우리가 마주하는 아픔에 대한 세심한 마음 채집활동을 통해 진짜 나를 만나기 위한 여정을 함께 하고자 합니다.",
                        "소담다담은 경험적으로 검증된 다양한 상담 이론을 통합적으로 접근하여 일상적인 고민 및 학교, 직장, 가정생활 적응 등의 어려움을 나누고, 건강한 심리적 성장을 도모하는 과정을 함께 하고자 합니다.",
                        "소담다담은 일상 속의 문제들에서 시작되어 혼자서는 점차 해결하기 어려워진 심리적 문제들에 귀 기울입니다. 사소하다고 무심코 지나쳐 버렸지만, 중요한 자리를 차지하고 있던 내면의 소리를 함께 함으로써 당신의 일상에 평온함과 작은 기쁨을 되찾아가는 과정을 만들어 갑니다.",
                        "소담다담은 자신만을 위한 시간과 공간을 향유하실 수 있도록 예약제로만 운영됩니다. 상담실을 내방하시는 분들이 최대한 다른 내방객들과 마주치지 않도록 상담시간 사이의 간격을 적절히 유지함으로써 상담에 대한 비밀 보장을 최우선으로 제공하고자 합니다.",
                        "소담다담은 국내 최고의 상담 관련 학회인 한국상담심리학회(한국심리학회 산하)의  공인 자격을 갖춘(상담심리전문가, 1급, 주수련감독자) 박사급 상담심리사가 직접 심리상담을 진행합니다. 상담 효과가 경험적으로 검증된 정신역동적 접근, 인지행동적 접근, 게슈탈트 접근, 인간중심접근 등을 통합적으로 적용하여 전문적인 심리상담을 실시합니다.",
                        "소담다담은 한국상담심리학회의 상담심리사 윤리강령을 준수하며, 내담자와 상담자의 상호간 인간적이며 전문적인 신뢰관계를 중시합니다. 아울러 내담자와 상담자 모두의 인격적인 존중을 바탕으로 상담을 진행합니다."
                ),
                Arrays.asList(
                        "../../../public/images/centerImg1.jpeg",
                        "../../../public/images/centerImg2.jpeg",
                        "../../../public/images/centerImg3.jpeg"
                ));
    }

    @Override
    public ReservationInfoDto getReservationInfo() {
        return createReservationInfo();
    }

    @Override
    public IntroductionDto getIntroduction() {
        return createIntroduction();
    }
}
