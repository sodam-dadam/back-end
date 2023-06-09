package com.sodamdadam.server.centerinfo.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class IntroductionDto {
    private String title;
    private String headText;
    private String img;
    private String alt;
    private List<String> content;
    private List<String> detailImg;

    public IntroductionDto(String title, String headText, String img, String alt, List<String> content, List<String> detailImg) {
        this.title = title;
        this.headText = headText;
        this.img = img;
        this.alt = alt;
        this.content = content;
        this.detailImg = detailImg;
    }
}
