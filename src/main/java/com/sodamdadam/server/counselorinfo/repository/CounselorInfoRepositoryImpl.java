package com.sodamdadam.server.counselorinfo.repository;

import com.sodamdadam.server.counselorinfo.dto.CareerDto;
import com.sodamdadam.server.counselorinfo.dto.response.CounselorInfoDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CounselorInfoRepositoryImpl implements CounselorInfoRepository{

    private CounselorInfoDto createCounselorInfo() {
        List<CareerDto> careerDtoList = new ArrayList<>();

        List<String> careerListKwon = Arrays.asList(
                "아주대학교 일반대학원 교육학 박사(교육상담 및 심리 전공)",
                "현) 경기대학교 학생상담센터 연구교수",
                "아주대학교 학생상담센터 책임상담원(주수퍼바이저)",
                "경기대학교 학생상담센터 전임상담원(주수퍼바이저)",
                "의왕시청소년상담센터 통합지원팀장",
                "심리상담센터 행복나무 부센터장",
                "위너스제이엠 협약 상담사",
                "(주) 휴먼 다이나믹 EAP 상담",
                "한국상담심리학회 상담심리사 1급(주수련감독자)",
                "한국정신건강상담사협의회 정신건강증진상담사 1급",
                "여성가족부 청소년상담사 1급",
                "한국힐링문화진흥협회 힐링원예지도사 1급"
        );

        List<String> careerListKimJ = Arrays.asList(
                "상명대학교 학생상담센터 책임연구원",
                "가천대학교 학생상담센터 책임연구원",
                "연세드림심리상담센터 상담원",
                "강남대학교 학생생활상담소 상담원",
                "봄, 심리상담센터장",
                "한양대학교 상담심리대학원 강사",
                "경기대학교 행정복지상담대학원 강사",
                "서울시 지방 병무청 병역 판정관",
                "상담심리사 1급(한국상담심리학회)",
                "청소년상담사 2급(여성가족부)"
        );

        List<String> careerListKimH = Arrays.asList(
                "가톨릭대학교 학생생활상담소 상담원",
                "고려대학교 학생상담센터 상담원",
                "양천구청소년상담복지센터 상담원",
                "경기대학교 학생상담센터 전임상담원",
                "서울청소년상담복지센터 청소년동반자",
                "상담심리사 2급(한국상담심리학회)",
                "청소년상담사 2급(여성가족부)"
        );

        careerDtoList.add(new CareerDto("../../../public/images/centerImg1.jpeg", "권문희", "교육학 박사 PH.D", careerListKwon));
        careerDtoList.add(new CareerDto("../../../public/images/centerImg1.jpeg", "김정희", "교육학 박사 PH.D", careerListKimJ));
        careerDtoList.add(new CareerDto("../../../public/images/centerImg1.jpeg", "김혜미", "아주대학교 박사 과정", careerListKimH));

        CounselorInfoDto response = new CounselorInfoDto<>("가온해 우리는 별하 감사합니다 도담도담 나비잠 함초롱하다 아슬라 사과 옅구름 나비잠 아름드리 나비잠 다솜 도담도담 여우비 별빛 도서 소록소록 로운 함초롱하다 바람꽃 별빛 여우비 예그리나 포도 사과 감사합니다 미리내 노트북 컴퓨터 책방 도르레 책방 바나나 가온누리 여우비 나래 그루잠 가온해 나래 별하 포도 우리는 별빛 여우별달볓 안녕 포도 아름드리. 옅구름 감사합니다 가온해 그루잠 달볓 옅구름 함초롱하다 별빛 우리는 예그리나예그리나 이플 별빛 도르레 아름드리 미쁘다 아슬라 감또개 도르레 도서 아름드리 소록소록 옅구름 예그리나 미쁘다늘품 감또개 아름드리 도담도담 가온해 이플 이플 별빛 아련 사과 예그리나 감또개 감사합니다 예그리나 사과노트북 다솜 달볓 산들림 달볓 가온누리 미쁘다 비나리 감사합니다 함초롱하다. 소솜 소록소록 달볓 나비잠 안녕아련 안녕 가온해 우리는 우리는 사과 옅구름 달볓 예그리나 예그리나 아슬라 비나리 달볓 우리는 로운 감사합니다감사합니다 노트북 우리는 컴퓨터 함초롱하다 비나리 포도 도르레 미리내 가온해 도르레 함초롱하다 가온누리미리내 감또개 포도 비나리 비나리 가온해 도서관 달볓 도담도담 이플 감또개 아름드리 소솜 나비잠 포도 도서관.", "끝맺음말", careerDtoList);

        return response;
    }

    @Override
    public CounselorInfoDto getCounselorInfo() {
        return createCounselorInfo();
    }
}
