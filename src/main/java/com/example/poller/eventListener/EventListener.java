package com.example.poller.eventListener;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
@Slf4j
public class EventListener {

    @Autowired
    private MongoTemplate mongoTemplate;

    @KafkaListener(topics = "cocktail")
    public void listenToCocktailTopic(String topic, String message){
        log.info("Received event from cocktail topic: {} -->", message);
        saveToMongoDb(message, topic);
        log.info("cocktail topic data saved {}, to database", message);
    }

    @KafkaListener(topics = "randomuser")
    public void listenToRandomUserTopic(String topic, String message){
        log.info("Received event from randomuser topic: {} -->", message);
        saveToMongoDb(message, topic);
        log.info("randomuser topic data saved {}, to database",message);
    }
    public void saveToMongoDb(String message, String collectionName){
        mongoTemplate.save(message, collectionName);
    }
}
