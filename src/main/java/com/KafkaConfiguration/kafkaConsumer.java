package com.KafkaConfiguration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.controller.Message;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
@RestController
@Configuration
public class kafkaConsumer {

	@Autowired
	private RestTemplate restTemplate;

	private final SimpMessageSendingOperations messagingTemplate;

	@KafkaListener(topics = AppConstant.Topic_Name, groupId = AppConstant.group_Id)
	public String consume(String data) {
		System.out.println(data);
		// messagingTemplate.convertAndSend("/topic/live-feed", data);

		List ll = this.restTemplate.getForObject("http://localhost:8082/product/get/allProductSell", List.class);
		int aa = (int) Math.random();
		String str = Integer.toString(aa);
		int dd = Integer.parseInt(data);
		Message ss = new Message("Totato" + str, dd);
		messagingTemplate.convertAndSend("/topic/return-to", ss);
		return data;
	}

}
