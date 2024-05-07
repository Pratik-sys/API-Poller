package com.example.poller.eventListener;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class EventListener {

    @Autowired
    private MongoTemplate mongoTemplate;

    @KafkaListener(topics = "cocktail")
    public void listenToTopicAndSaveToDB(String message){
        saveToMongoDb(message, "cocktail");
    }

    public void saveToMongoDb(String message, String collectionName){
        mongoTemplate.save(message, collectionName);
    }
}
