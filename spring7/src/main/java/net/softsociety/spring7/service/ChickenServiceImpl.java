package net.softsociety.spring7.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring7.domain.Chicken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ChickenServiceImpl implements ChickenService{
    @Value("http://127.0.0.1:8000/chicken")
    String url;

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Override
    public Map<String, Object> chicken(Chicken chicken) throws JsonProcessingException {
        log.info("(서비스단) 날씨 정보 : {}", chicken);
        log.info("FastAPI 서버 URL : {}", url);

        Map<String, Object> result = new HashMap<>(); // 에러 발생 시 반환
        Map<String, Object> map = null;
        try {
            Map<String, Double> parameters = new HashMap<>();

            // 서버로 보낼 데이터(쿼리스트링) 준비
            parameters.put("rain", chicken.getRain());
            parameters.put("coldc", chicken.getColdc());
            parameters.put("hotc", chicken.getHotc());
            parameters.put("holiday", chicken.getHoliday());

            // 헤더 준비
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            RestTemplate restTemplate = new RestTemplate();

            // post로 전송할 경우 postForEntity를 사용 (1: 요청 URL, 2: 요청 바디, 3: 응답바디)
            ResponseEntity<String> response = restTemplate.postForEntity(url, parameters, String.class);

            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();

            map = gson.fromJson(response.getBody(), Map.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body", e.getStatusText());
            System.out.println(result);
        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body", "exception 발생");
            System.out.println(result);
            return result;
        }
        return map;
    }
}
