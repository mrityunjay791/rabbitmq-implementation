package com.mrityunjay.rabitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mrityunjay.rabitmq.domain.Employee;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate2;
	
	@Value("${mrityunjay.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${mrityunjay.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(Employee company) {
		rabbitTemplate2.convertAndSend(exchange, routingkey, company);
		System.out.println("Send msg = " + company);
	    
	}
}