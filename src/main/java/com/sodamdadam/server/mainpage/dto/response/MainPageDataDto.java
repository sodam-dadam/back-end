package com.sodamdadam.server.mainpage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MainPageDataDto<T> {

    private T mainHeader;
    private T consulting;
    private T education;
}
