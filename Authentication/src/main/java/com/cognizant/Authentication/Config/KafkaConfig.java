package com.cognizant.Authentication.Config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.gson.Gson;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.cognizant.Authentication.Model.UserAuth;
import com.cognizant.Authentication.Repository.RepositoryAuth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Configuration
public class KafkaConfig {
	@Autowired
	RepositoryAuth repositoryAuth;
	@Autowired
    Gson gson;

	
	private static final Logger logger = LoggerFactory.getLogger(KafkaConfig.class);
	 
    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String value)  {
       
        UserAuth user = gson.fromJson(value, UserAuth.class);
        System.out.println("Consumed Message : -" + user.getEmail() + user.getPassword());
         repositoryAuth.save(user);

}
}
