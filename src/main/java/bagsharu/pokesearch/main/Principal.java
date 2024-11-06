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
//
//
        MainMenu menuControl = new MainMenu();
//
//        menuControl.printMenu();
//

//

//

//
//        System.out.println(pokemon);

//

////        pokemonData.forEach(System.out::println);

        int control = -1;

        while (control !=  0) {

            menuControl.printMenu();
            control = scanner.nextInt();

            switch (control) {

                case 1:
                    // Ask the user what pokemon they would like to get info.
                    System.out.println("Type what pokemon you'd like to search: ");
                    var searchPoke = scanner.nextLine();
                    var searchURL = URL_BASE + searchPoke;

                    // Serializes pokemoninfo and creates a Pokemon object.
                    PokemonInfo pokeTest = menuControl.pokemonSearch(searchURL);
                    Pokemon pokemon = new Pokemon(pokeTest);

                    // Adds a pokemon to the database
                    menuControl.pokemonAdd(pokemonData,pokemon);
                    repository.save(pokemon);
                case 2:
                    // Search the databse for all persisted pokemon
                    List<Pokemon> pokemonList = repository.findAll();

                    // Prints all pokemon
                    pokemonList.forEach(System.out::println);
                case 0:
                    break;
                default:
                    System.out.println("Invalid operation.");
            }
        }




    }
}
