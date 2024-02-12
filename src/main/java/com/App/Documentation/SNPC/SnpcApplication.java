package com.App.Documentation.SNPC;

import com.App.Documentation.SNPC.entity.Document;
import com.App.Documentation.SNPC.entity.Employee;
import com.App.Documentation.SNPC.entity.User;
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

		Employee employee=new Employee("John","Doe","John@gmail.com");
		Employee employee2=new Employee("Jean","Doe","Jean@gmail.com");
		employeeRepository.save(employee);
		employeeRepository.save(employee2);

		Document document= new Document("pdf","Salary",12);
		Document document2= new Document("word","Expenses",22);
		documentRepository.save(document);
		documentRepository.save(document2);

		userRepository.save(new User("user","$2y$10$sWsZSV.WLTqQkyhPWu9Tw.CY0Aue3rVhQ3O1ctF36AgFKh1hfikFW","User"));
		userRepository.save(new User("admin","$2y$10$2ZewJI8WOMsotPvodIWWzuPsH0JJASZOpc5cInO15Hyx7gyzgi39e","ADMIN"));
		documentRepository
				.findAll().forEach(document1 -> logger.info(document.getName()+" "+document.getType()));
		employeeRepository.findAll().forEach(em->logger.info(em.getFirstName()));




	}
}
