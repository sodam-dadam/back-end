package com.sodamdadam.server.mainpage.service;

import com.sodamdadam.server.global.dto.response.CommonResponse;
import com.sodamdadam.server.mainpage.enums.SubCategory;
import com.sodamdadam.server.mainpage.dto.response.SendMainPageDataDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainPageService {

    private final List<SubCategory> consultingList = new ArrayList<>();
    private final List<SubCategory> educationList = new ArrayList<>();
    private final SendMainPageDataDto response;

    public MainPageService() {
        consultingList.add(SubCategory.CONSULTING_1);
        consultingList.add(SubCategory.CONSULTING_2);
        consultingList.add(SubCategory.CONSULTING_3);
        consultingList.add(SubCategory.CONSULTING_4);
        consultingList.add(SubCategory.CONSULTING_5);

        educationList.add(SubCategory.EDUCATION_1);
        educationList.add(SubCategory.EDUCATION_2);
        educationList.add(SubCategory.EDUCATION_3);

        response = new SendMainPageDataDto<>(consultingList, educationList);
    }

    public ResponseEntity<CommonResponse> sendData(){

        return new ResponseEntity<>(
                CommonResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("MainPage Response Data Success")
                        .data(response)
                        .build(),
                HttpStatus.valueOf(HttpStatus.OK.value())
        );
    }
}