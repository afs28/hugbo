package is.hi.hbv501g.hugbo.Persistence.Repositories;

import is.hi.hbv501g.hugbo.Persistence.Entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The recipe repository.
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Kare
 */

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Recipe save(Recipe recipe);
    void delete(Recipe recipe);
    List<Recipe> findAll();
    Recipe findByRecipeID(Long recipeID);
    List<Recipe> findByTitle(String title);

    //List<Recipe> findByTitle(String title);

}
