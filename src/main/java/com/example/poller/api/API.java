package com.example.poller.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
@Slf4j
public class API {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Async
    @Scheduled(fixedRate = 5000)
    public void fetchContent(){
        pollApi("https://www.thecocktaildb.com/api/json/v1/1/random.php", "cocktail");
        pollApi("https://randomuser.me/api/", "randomuser");
    }
    public void pollApi(String url, String topics){
        String response = restTemplate.getForObject(url, String.class);
        log.info("Response fetched by polling API - {}: {}", url,response);
        kafkaTemplate.send(topics, response);
        log.info("Sent response via kafka");
    }
}
