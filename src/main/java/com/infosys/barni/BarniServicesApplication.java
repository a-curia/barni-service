package com.infosys.barni;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BarniServicesApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(BarniServicesApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BarniServicesApplication.class, args);
		
		logger.info("BarniService has started!");
	}
	
//	@Bean
//	public CommandLineRunner setup(ToDoRepository toDoRepository) {
//		return (args) -> {
//			toDoRepository.save(new ToDo("Remove unused imports", true));
//			toDoRepository.save(new ToDo("Clean the code", true));
//			toDoRepository.save(new ToDo("Build the artifacts", false));
//			toDoRepository.save(new ToDo("Deploy the jar file", true));
//			logger.info("The sample data has been generated");
//		};
//	}

	
}
