package com.ananops.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

/**
 * The class ananops zipkin application.
 *
 * @author ananops.net@gmail.com
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class AnanOpsZipkinApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(AnanOpsZipkinApplication.class, args);
	}
}
