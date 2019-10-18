package tech.juniorlima.clickbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ClickbusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClickbusApplication.class, args);
	}
}
