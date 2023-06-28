package com.sodamdadam.server.mainpage.repository;

import com.sodamdadam.server.mainpage.dto.response.MainPageDataDto;
import com.sodamdadam.server.mainpage.enums.MainHeader;
import com.sodamdadam.server.mainpage.enums.SubCategory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MainPageRepositoryImpl implements MainPageRepository{

    private MainPageDataDto craeteMainPageDataDto() {

        List<MainHeader> mainHeaderList = new ArrayList<>();
        List<SubCategory> consultingList = new ArrayList<>();
        List<SubCategory> educationList = new ArrayList<>();

        mainHeaderList.add(MainHeader.CENTER_INFO);
        mainHeaderList.add(MainHeader.COUNSELOR_INFO);
        mainHeaderList.add(MainHeader.COUNSELING);
        mainHeaderList.add(MainHeader.EDUCATION);
        mainHeaderList.add(MainHeader.NOTICE);

        consultingList.add(SubCategory.CONSULTING_1);
        consultingList.add(SubCategory.CONSULTING_2);
        consultingList.add(SubCategory.CONSULTING_3);
        consultingList.add(SubCategory.CONSULTING_4);
        consultingList.add(SubCategory.CONSULTING_5);

        educationList.add(SubCategory.EDUCATION_1);
        educationList.add(SubCategory.EDUCATION_2);
        educationList.add(SubCategory.EDUCATION_3);

        MainPageDataDto response = new MainPageDataDto<>(mainHeaderList, consultingList, educationList);

        return response;
    }

    @Override
    public MainPageDataDto getMainPageData() {
        return craeteMainPageDataDto();
    }
}
