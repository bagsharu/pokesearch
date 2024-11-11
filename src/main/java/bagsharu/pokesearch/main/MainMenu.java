package bagsharu.pokesearch.main;


import bagsharu.pokesearch.model.Pokemon;
import bagsharu.pokesearch.model.PokemonInfo;
import bagsharu.pokesearch.service.ApiRequest;
import bagsharu.pokesearch.service.ConvertData;

import java.util.List;

public class MainMenu {

    private ApiRequest apiRequest = new ApiRequest();

    public void printMenu() {

        String ENTRY_TEXT = """
                
                --------------------------------
                Welcome to PokéSearch:
                What operation would you like to do?
                1- Search and Pokemon's Info
                2- List all searched Pokemon
                3- Search Pokemon in database
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

}
