package bagsharu.pokesearch.repository;

import bagsharu.pokesearch.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Optional<Pokemon> findByPokemonNameContainingIgnoreCase(String pokeName);

    List<Pokemon> findByPokemonTypeMainContainingIgnoreCase(String typeSearch);

    @Query("SELECT p FROM Pokemon p WHERE p.pokemonTypeMain LIKE %:param% OR p.pokemonTypeSecond LIKE %:param%")
    List<Pokemon> searchByType(@Param("param") String param);

}
