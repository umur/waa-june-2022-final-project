package com.waa.amp;

import com.waa.amp.entity.Role;
import com.waa.amp.entity.User;
import com.waa.amp.repository.RoleRepository;
import com.waa.amp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class AmpApplication {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(AmpApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			var role = roleRepository.save(new Role(null, "ADMIN"));
			var user = userRepository.save(new User(null, "admin", "admin", List.of(role)));
		};
	}

}
