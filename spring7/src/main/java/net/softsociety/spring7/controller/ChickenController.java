package net.softsociety.spring7.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring7.domain.Chicken;
import net.softsociety.spring7.domain.Iris;
import net.softsociety.spring7.service.ChickenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@Slf4j
public class ChickenController {

    @Autowired
    ChickenService service;

    /**
     * 머신러닝을 위한 화면 요청
     * @return
     */
    @GetMapping("/chicken")
    public String predict() {
        return "chicken";
    }

    @PostMapping("/chicken")
    @ResponseBody
    public Map<String, Object> chicken(Chicken chicken) {
        log.info("날씨 정보: " + chicken.toString());

        Map<String, Object> result = null;

        try {
            result = service.chicken(chicken);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        log.info("분석한 결과물 : {} ", result.toString());

        return result;
    }

}
