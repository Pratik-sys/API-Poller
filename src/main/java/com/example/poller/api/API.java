package com.example.poller.api;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class API {

    @Autowired
    private RestTemplate restTemplate;

    @Async
    @Scheduled(fixedRate = 5000)
    public void fetchContent(){
        pollApi("https://www.thecocktaildb.com/api/json/v1/1/random.php", "cocktail");
        pollApi("https://randomuser.me/api/", "randomuser");
    }
    public void pollApi(String url, String topics){
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(String.format("Response for topic is %s", response));
    }
}
