package bagsharu.pokesearch.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PokemonInfo(@JsonAlias("name") String pokeName,
                          @JsonAlias("weight") String pokeWeight) {
}
