package com.sodamdadam.server.counselorinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CareerDto {

    private String img;
    private String name;
    private String role;
    private List<String> careerList;

}
