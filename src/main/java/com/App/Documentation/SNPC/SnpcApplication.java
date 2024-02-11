package com.App.Documentation.SNPC;

import com.App.Documentation.SNPC.repository.DocumentRepository;
import com.App.Documentation.SNPC.repository.EmployeeRepository;
import com.App.Documentation.SNPC.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.logging.java.JavaLoggingSystem;

@SpringBootApplication
public class SnpcApplication implements CommandLineRunner {
	@Autowired
	 private DocumentRepository documentRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private UserRepository userRepository;

	private  static  final Logger logger= LoggerFactory.getLogger(SnpcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SnpcApplication.class, args);
		logger.info("Application Start");


	}

	@Override
	public void run(String... args) throws Exception {



	}
}
