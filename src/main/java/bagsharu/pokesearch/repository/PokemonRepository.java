package bagsharu.pokesearch.repository;

import bagsharu.pokesearch.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
