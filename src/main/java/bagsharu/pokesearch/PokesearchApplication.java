package bagsharu.pokesearch;

import bagsharu.pokesearch.main.Principal;
import bagsharu.pokesearch.model.PokemonInfo;
import bagsharu.pokesearch.repository.PokemonRepository;
import bagsharu.pokesearch.service.ApiRequest;
import bagsharu.pokesearch.service.ConvertData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokesearchApplication implements CommandLineRunner {

	@Autowired
	private PokemonRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(PokesearchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal(repository);

		principal.SearchPokemon();
	}
}
