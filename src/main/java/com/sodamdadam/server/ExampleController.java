package com.sodamdadam.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @RequestMapping("/")
    public String index(){
        return "sodam-dadam 프로젝트 시작!!!";
    }

}
정