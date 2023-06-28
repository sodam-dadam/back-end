package com.sodamdadam.server.mainpage.service;

import com.sodamdadam.server.global.dto.response.CommonResponse;
import com.sodamdadam.server.mainpage.enums.MainHeader;
import com.sodamdadam.server.mainpage.enums.SubCategory;
import com.sodamdadam.server.mainpage.dto.response.MainPageDataDto;
import com.sodamdadam.server.mainpage.repository.MainPageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MainPageService {

    private final MainPageRepository mainPageRepository;

    public MainPageDataDto getMainPageData() {
        return mainPageRepository.getMainPageData();
    }

}
