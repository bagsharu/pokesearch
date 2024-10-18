package bagsharu.pokesearch;

import bagsharu.pokesearch.main.Principal;
import bagsharu.pokesearch.model.PokemonInfo;
import bagsharu.pokesearch.service.ApiRequest;
import bagsharu.pokesearch.service.ConvertData;
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

		Principal principal = new Principal();

		principal.SearchPokemon();
	}
}
