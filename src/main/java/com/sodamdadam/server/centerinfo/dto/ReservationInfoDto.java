package com.sodamdadam.server.centerinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReservationInfoDto<T> {

    private String title;
    private T reservation;
    private T counselingTime;
}
