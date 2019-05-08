package snmaddula.demo;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * 
 * @author snmaddula
 *
 */
@SpringBootApplication
@ConfigurationProperties
@PropertySource("classpath:error.properties")
public class DemoApplication {

	private Map<String, Integer> errors;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner cli() {
		return (args) -> {
			System.out.println(errors); // you can print and see the error properties injected to this map.
		};
	}

	public void setErrors(Map<String, Integer> errors) {
		this.errors = errors;
	}

}
