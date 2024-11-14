package bagsharu.pokesearch.repository;

import bagsharu.pokesearch.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    // This method simply search the databse for a pokemon with the desired name
    Optional<Pokemon> findByPokemonNameContainingIgnoreCase(String pokeName);


    // This method searches the column of the pokemon types and checks if they contain the type asked
    @Query("SELECT p FROM Pokemon p WHERE p.pokemonTypeMain LIKE %:typeSearch% OR p.pokemonTypeSecond LIKE %:typeSearch%")
    List<Pokemon> searchByType(@Param("typeSearch") String param);

}
