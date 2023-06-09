package com.sodamdadam.server.mainpage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SendMainPageDataDto<T> {

    private T mainHeader;
    private T consulting;
    private T education;
}
