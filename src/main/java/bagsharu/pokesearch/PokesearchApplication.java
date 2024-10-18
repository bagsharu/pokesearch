package bagsharu.pokesearch;

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
		var apiRequest = new ApiRequest();
		var json = apiRequest.requestData("https://pokeapi.co/api/v2/pokemon/toxapex");
		var convert = new ConvertData();

		PokemonInfo pokeTest = convert.convertData(json, PokemonInfo.class);

		System.out.println(pokeTest);
	}
}
