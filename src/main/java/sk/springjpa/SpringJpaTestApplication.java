package sk.springjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaTestApplication.class, args);
	}

	@Bean
	public CommandLineRunner runnerSimple(DemoApp demoApp) {
		return args -> demoApp.runAbstract();
//		return args -> demoApp.runRelations();
	}


}
