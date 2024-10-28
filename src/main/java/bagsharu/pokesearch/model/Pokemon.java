package bagsharu.pokesearch.model;

import jakarta.persistence.*;

@Entity
@Table(name= "pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPokemon;

    @Column(unique = true)
    private String pokemonName;

    @Enumerated(EnumType.STRING)
    private String pokemonTypeMain;

    @Enumerated(EnumType.STRING)
    private String pokemonTypeSecond;
    private Double pokemonWeight;

    public Pokemon(PokemonInfo pokemonInfo) {

        this.pokemonName = pokemonInfo.pokeName();
        this.pokemonTypeMain = pokemonInfo.pokeType().get(0).type().name().toUpperCase();

        // If the pokémon has double-typing, attribute to second type
        if (pokemonInfo.pokeType().size() == 2) {
            this.pokemonTypeSecond = pokemonInfo.pokeType().get(1).type().name().toUpperCase();
        }

        // Converts from String to Integer
        this.pokemonWeight = Double.valueOf(Integer.valueOf(pokemonInfo.pokeWeight()));
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

    public Double getPokemonWeight() {
        return pokemonWeight;
    }

    // Getter and Setter for ID

    public Long getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(Long idPokemon) {
        this.idPokemon = idPokemon;
    }

    @Override
    public String toString() {
        return "Here's the basic info of " + pokemonName.substring(0,1).toUpperCase() + pokemonName.substring(1) +
                "\nType: " + pokemonTypeMain + " " + pokemonTypeSecond +
                "\nWeight: " + pokemonWeight/10 + "kg";
    }
}
