package bagsharu.pokesearch.model;

import java.util.Locale;

public class Pokemon {

    private String pokemonName;
    private String pokemonTypeMain;
    private String pokemonTypeSecond;
    private Integer pokemonWeight;

    public Pokemon(PokemonInfo pokemonInfo) {

        this.pokemonName = pokemonInfo.pokeName();
        this.pokemonTypeMain = pokemonInfo.pokeType().get(0).type().name().toUpperCase();

        // If the pokémon has double-typing, attribute to second type
        if (pokemonInfo.pokeType().size() == 2) {
            this.pokemonTypeSecond = pokemonInfo.pokeType().get(1).type().name().toUpperCase();
        }

        // Converts from String to Integer
        this.pokemonWeight = Integer.valueOf(pokemonInfo.pokeWeight());
    }


}
