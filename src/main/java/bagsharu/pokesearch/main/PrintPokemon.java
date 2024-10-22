package bagsharu.pokesearch.main;

import bagsharu.pokesearch.model.PokemonInfo;

public class PrintPokemon {


    public static void PrintPoke(PokemonInfo pokeInfo){

        System.out.println("The Pokémon you searched for is: " + pokeInfo.pokeName().substring(0,1).toUpperCase() + pokeInfo.pokeName().substring(1));
        System.out.println("Their type is: " + pokeInfo.pokeType());
    }
}
