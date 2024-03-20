package com.kafkaConfiguration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.constant.AppConstant;

@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic topic() {

		return TopicBuilder.name(AppConstant.LOCATION_TOPIC_NAME).partitions(1).replicas(1).build();
	}

}
