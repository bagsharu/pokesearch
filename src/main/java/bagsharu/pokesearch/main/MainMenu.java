package bagsharu.pokesearch.main;


import bagsharu.pokesearch.model.Pokemon;
import bagsharu.pokesearch.model.PokemonInfo;
import bagsharu.pokesearch.service.ApiRequest;
import bagsharu.pokesearch.service.ConvertData;

import java.util.List;

public class MainMenu {

    private ApiRequest apiRequest = new ApiRequest();

    private final String ENTRY_TEXT = "--------------------------------\n"+
                                "Welcome to PokéSearch:\n"+
                                "What operation would you like to do?" +
                                "\n1- Search and Pokemon's Info" +
                                "\n2- List all searched Pokemon" +
                                "\n0- Leave" +
                               "\n--------------------------------";

    public void printMenu() {

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
