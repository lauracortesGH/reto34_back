package co.usa.ciclo3.reto34.reto34;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"co.usa.ciclo3.reto34.reto34"})
@SpringBootApplication
public class Reto34Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto34Application.class, args);
	}
}
