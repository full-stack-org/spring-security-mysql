package org.websparrow;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.websparrow.entity.User;
import org.websparrow.repository.UserRepository;

@SpringBootApplication
public class BootSecurityJpaApp {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(BootSecurityJpaApp.class, args);
	}

	@PostConstruct
	public void insertData() {
		List<User> usersList = new ArrayList<>();
		User user = new User();
		user.setId(101);
		user.setActive(true);
		user.setPassword("user");
		user.setRoles("ROLE_USER");
		user.setUserName("user@123");
		
		User admin = new User();
		admin.setId(102);
		admin.setActive(true);
		admin.setPassword("admin");
		admin.setRoles("ROLE_ADMIN");
		admin.setUserName("admin@123");

		usersList.add(user);
		usersList.add(admin);

		userRepository.saveAll(usersList);
	}
}
