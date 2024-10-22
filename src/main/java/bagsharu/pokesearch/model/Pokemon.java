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

    // Getter methods, no need for Setter, pokemon info should not be changed
    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokemonTypeMain() {
        return pokemonTypeMain;
    }

    public String getPokemonTypeSecond() {
        return pokemonTypeSecond;
    }

    public Integer getPokemonWeight() {
        return pokemonWeight;
    }

    @Override
    public String toString() {
        return "Here's the basic info of " + pokemonName.substring(0,1).toUpperCase() + pokemonName.substring(1) +
                "\nType: " + pokemonTypeMain + " " + pokemonTypeSecond +
                "\nWeight: " + pokemonWeight;
    }
}
