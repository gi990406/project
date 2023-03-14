package net.softsociety.spring7.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring7.domain.Iris;
import net.softsociety.spring7.service.PredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@Slf4j
public class PredictController {

    @Autowired
    PredictService service;

    /**
     * 머신러닝을 위한 화면 요청
     * @return
     */
    @GetMapping("/predict")
    public String predict() {
        return "predict";
    }

    @PostMapping("/predict")
    @ResponseBody
    public Map<String, Object> predict(Iris iris) {
        log.info("붓꽃 정보 " + iris.toString());

        Map<String, Object> result = null;

        try {
            result = service.predict(iris);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        log.info("분석한 결과물 : {} ", result.toString());

        return result;
    }
}
