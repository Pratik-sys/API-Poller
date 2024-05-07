package com.example.poller.eventListener;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.xml.transform.sax.SAXResult;

@Component
@AllArgsConstructor
public class EventListener {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveToMongoDb(String message, String collectionName){
        mongoTemplate.save(message, collectionName);
    }
}
