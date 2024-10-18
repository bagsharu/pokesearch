package bagsharu.pokesearch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokesearchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PokesearchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
	}
}
