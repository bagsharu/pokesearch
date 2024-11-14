package bagsharu.pokesearch.main;


import bagsharu.pokesearch.model.Pokemon;
import bagsharu.pokesearch.model.PokemonInfo;
import bagsharu.pokesearch.repository.PokemonRepository;
import bagsharu.pokesearch.service.ApiRequest;
import bagsharu.pokesearch.service.ConvertData;

import java.util.List;
import java.util.Optional;

public class MainMenu {

    private ApiRequest apiRequest = new ApiRequest();

    private PokemonRepository repository;
    public MainMenu(PokemonRepository repository) {
        this.repository = repository;
    }

    public void printMenu() {

        String ENTRY_TEXT = """
                
                --------------------------------
                Welcome to PokéSearch:
                What operation would you like to do?
                1- Search and Pokemon's Info
                2- List all searched Pokemon
                3- Search Pokemon in database
                4- Search by Type
                0- Leave
                --------------------------------
                """;
        System.out.println(ENTRY_TEXT);
    }

    public PokemonInfo pokemonSearch(String nameSearch) {

        // Recieve an URL as parameter, then requests from API
        var json = apiRequest.requestData(nameSearch);

        // Returns a Record with the Pokemon's info
        var convert = new ConvertData();
        return convert.convertData(json, PokemonInfo.class);
    }


    public void pokemonAdd(List<Pokemon> pokeList, Pokemon poke) {

        pokeList.add(poke);
    }

    public void SearchDatabase(String pokeName) {

        Optional<Pokemon> pokemonSearched = repository.findByPokemonNameContainingIgnoreCase(pokeName);

        if (pokemonSearched.isPresent()) {
            System.out.println(pokemonSearched.get());
        } else {
            System.out.println("Pokemon not found in database.");
        }
    }

    public void SearchType (String typeSearch) {
        List<Pokemon> pokeByType = repository.searchByType(typeSearch.toUpperCase());

        if (pokeByType.isEmpty()){
            System.out.println("No pokemon of " + typeSearch.toUpperCase() + " type found.");
        } else
            System.out.println("Here are the " + typeSearch.toUpperCase() + " type Pokemon:");
            pokeByType.forEach(System.out::println);
    }

}
