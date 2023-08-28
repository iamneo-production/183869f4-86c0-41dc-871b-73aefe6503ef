package com.peirisabhi.transactionmonitoringservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class TransactionMonitoringServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionMonitoringServiceApplication.class, args);
	}

}
