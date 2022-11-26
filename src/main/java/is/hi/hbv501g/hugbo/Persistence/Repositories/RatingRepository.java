package is.hi.hbv501g.hugbo.Persistence.Repositories;

import is.hi.hbv501g.hugbo.Persistence.Entities.RecipeRatings;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The recipe rating repository.
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Kare
 */
public interface RatingRepository extends JpaRepository<RecipeRatings, Long> {

    RecipeRatings findByRatingID(long ratingID);
    RecipeRatings[] findByRecipeID(long recipeID);
    RecipeRatings save(RecipeRatings recipeRatings);
    void delete(RecipeRatings recipeRatings);
}
