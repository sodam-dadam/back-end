package com.sodamdadam.server.centerinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ReservationDto {

    private String img;
    private int step;
    private String stepName;
    private String stepInfo;

}
