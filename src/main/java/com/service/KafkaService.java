package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.constant.AppConstant;


@Service
public class KafkaService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkatemlet;
	
	
	public boolean updateLocation(String location) {
			this.kafkatemlet.send(AppConstant.LOCATION_TOPIC_NAME,location);
	
		 return true;
		
	}

}