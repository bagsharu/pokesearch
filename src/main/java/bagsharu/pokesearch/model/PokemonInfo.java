package bagsharu.pokesearch.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PokemonInfo(@JsonAlias("name") String pokeName,
                          @JsonAlias("weight") String pokeWeight,
                          @JsonAlias("types") List<pokeTypeSlot> pokeType) {
}


record pokeTypeSlot (int slot,
                     TypeInfo type){

}

record TypeInfo (String name,
                 String url) {

}
