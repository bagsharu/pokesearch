package bagsharu.pokesearch.main;

import bagsharu.pokesearch.model.PokemonInfo;
import bagsharu.pokesearch.service.ApiRequest;
import bagsharu.pokesearch.service.ConvertData;

import java.util.Scanner;

public class Principal {


    private Scanner scanner = new Scanner(System.in);
    private final String URL_BASE = "https://pokeapi.co/api/v2/pokemon/";
    private ApiRequest apiRequest = new ApiRequest();

    // Method to display the search menu
    public void SearchPokemon () {

        // Ask the user what pokemon they would like to get info.
        System.out.println("Type what pokemon you'd like to search: ");
        var searchPoke = scanner.nextLine();
        var searchURL = URL_BASE + searchPoke;

        // Requests from pokeapi
        var json = apiRequest.requestData(searchURL);
        var convert = new ConvertData();
        PokemonInfo pokeTest = convert.convertData(json, PokemonInfo.class);

        // Display on screen the data recieved
        System.out.println(pokeTest);
        PrintPokemon.PrintPoke(pokeTest);


    }
}
