package ru.returnonintelligence.technobus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.returnonintelligence.technobus.config.JpaConfiguration;
/**
 * @author NIKIT on 11.07.2017.
 */
@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"ru.returnonintelligence.technobus"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class TechnobusApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnobusApplication.class, args);
	}
}
