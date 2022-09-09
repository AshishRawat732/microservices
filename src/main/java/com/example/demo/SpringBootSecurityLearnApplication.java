package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.models.User;
import com.example.demo.repo.UserRepository;

@SpringBootApplication
public class SpringBootSecurityLearnApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityLearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setEmail("john@gmail.com");
		user.setUsername("john");
		user.setPassword(this.bCryptPasswordEncoder.encode("durgesh"));
		user.setRole("ROLE_NORMAL");

		this.userRepository.save(user);

		User user1 = new User();
		user1.setEmail("roshni@gmail.com");
		user1.setUsername("roshni");
		user1.setPassword(this.bCryptPasswordEncoder.encode("durgesh"));
		user1.setRole("ROLE_ADMIN");

		this.userRepository.save(user1);

	}

}
