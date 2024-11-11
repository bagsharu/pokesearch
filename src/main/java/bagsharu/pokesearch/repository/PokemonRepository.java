package bagsharu.pokesearch.repository;

import bagsharu.pokesearch.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Optional<Pokemon> findByPokemonNameContainingIgnoreCase(String pokeName);

    List<Pokemon> findByPokemonTypeMainContainingIgnoreCase(String typeSearch);
}
