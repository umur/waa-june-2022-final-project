package com.waa.amp;

import com.waa.amp.entity.*;
import com.waa.amp.repository.*;
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
	private final TagRepository tagRepository;
	private final JobRepository jobRepository;

	private final StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(AmpApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			var role = roleRepository.save(new Role(null, "ADMIN"));
			var roleStudent = roleRepository.save(new Role(null, "STUDENT"));
			var roleFaculty = roleRepository.save(new Role(null, "FACULTY"));
			var user = userRepository.save(new User(null, "admin", "admin", List.of(role), UserType.ADMIN, true, null));
			var userStudent = userRepository.save(new User(null, "student", "student", List.of(roleStudent), UserType.STUDENT, true, null));
			var userFaculty = userRepository.save(new User(null, "faculty", "faculty", List.of(roleFaculty), UserType.FACULTY, true, null));
			var tag1 = tagRepository.save(new Tag(null, "Tag 1"));
			var tag2 = tagRepository.save(new Tag(null, "Tag 2"));
			var tag3 = tagRepository.save(new Tag(null, "Tag 3"));
			var tag4 = tagRepository.save(new Tag(null, "Tag 4"));

			var job1 = jobRepository.save(new Job(null, "description 1", List.of(tag1, tag2), "Iowa", "FairField", "KForce", user));
			var job2 = jobRepository.save(new Job(null, "description 2", List.of(tag4, tag3), "CA", "San Francisco", "Google", user));

			studentRepository.save(new Student(null, userStudent, "username@username", "firstname", "lastname", "cs", "3.5", "Fairfield"));
			//studentRepository.save(new Student(null, userStudent, "anwar@username", "anwar", "hossian", "cs", "3.5", "Fairfield"));

		};
	}
}
