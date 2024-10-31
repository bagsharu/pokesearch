package bagsharu.pokesearch.main;

import bagsharu.pokesearch.model.Pokemon;
import bagsharu.pokesearch.model.PokemonInfo;
import bagsharu.pokesearch.repository.PokemonRepository;
import bagsharu.pokesearch.service.ApiRequest;
import com.sun.tools.javac.Main;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {


    private Scanner scanner = new Scanner(System.in);
    private final String URL_BASE = "https://pokeapi.co/api/v2/pokemon/";

    private List<Pokemon> pokemonData = new ArrayList<>();
    private PokemonRepository repository;
    public Principal(PokemonRepository repository) {
        this.repository = repository;
    }

    // Method to display the search menu
    public void SearchPokemon () {
/*


        // Requests from pokeapi


        // Display on screen the data recieved
        System.out.println(pokeTest);

        // Implementation of static method
        PrintPokemon.PrintPoke(pokeTest);

        // toString of Pokemon.class
        Pokemon pokemon = new Pokemon(pokeTest);
        System.out.println(pokemon);
*/


        MainMenu menuControl = new MainMenu();

        menuControl.printMenu();

        // Ask the user what pokemon they would like to get info.
        System.out.println("Type what pokemon you'd like to search: ");
        var searchPoke = scanner.nextLine();
        var searchURL = URL_BASE + searchPoke;

        PokemonInfo pokeTest = menuControl.pokemonSearch(searchURL);
        Pokemon pokemon = new Pokemon(pokeTest);

        menuControl.pokemonAdd(pokemonData,pokemon);
        repository.save(pokemon);

        System.out.println(pokemon);
        pokemonData.forEach(System.out::println);




    }
}
