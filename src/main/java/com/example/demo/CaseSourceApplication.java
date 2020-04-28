package com.example.demo;

import java.util.UUID;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableBinding(Source.class)
public class CaseSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseSourceApplication.class, args);
	}
	private static final Logger log = LoggerFactory.getLogger(CaseSourceApplication.class);
	@InboundChannelAdapter(channel = Source.OUTPUT, poller = @Poller(fixedRate = "5000000"))
	public Message<?> generate() {
		CaseSourceData caseData=new CaseSourceData(1,1,"016901552710","1001");
		System.out.println("Sending: " + caseData);
		return MessageBuilder.withPayload(caseData)
				.setHeader(KafkaHeaders.CORRELATION_ID, UUID.randomUUID().toString())
				.build();
	}

}



