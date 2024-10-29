package bagsharu.pokesearch.main;

import bagsharu.pokesearch.model.Pokemon;
import bagsharu.pokesearch.model.PokemonInfo;
import bagsharu.pokesearch.service.ApiRequest;
import com.sun.tools.javac.Main;


import java.util.Scanner;

public class Principal {


    private Scanner scanner = new Scanner(System.in);
    private final String URL_BASE = "https://pokeapi.co/api/v2/pokemon/";

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

        System.out.println(pokemon);



    }
}
