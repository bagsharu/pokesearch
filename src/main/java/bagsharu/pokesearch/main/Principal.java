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

        MainMenu menuControl = new MainMenu(repository);

        int control = -1;

        while (control !=  0) {

            menuControl.printMenu();
            control = scanner.nextInt();
            scanner.nextLine();

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
                    break;
                case 2:
                    // Search the databse for all persisted pokemon
                    List<Pokemon> pokemonList = repository.findAll();

                    // Prints all pokemon
                    pokemonList.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Type what pokemon you would like to search:");
                    var pokeSearch = scanner.nextLine();
                    menuControl.SearchDatabase(pokeSearch);
                    break;
                case 4:
                    System.out.println("What pokemon type you would like to search?");
                    var typeSearch = scanner.nextLine();
                    menuControl.SearchType(typeSearch);
                case 0:
                    System.out.println("Ending operations.");
                    break;
                default:
                    System.out.println("Invalid operation.");
            }
        }




    }


}
