package is.hi.hbv501g.hugbo.Services;

import is.hi.hbv501g.hugbo.Persistence.Entities.RecipeRatings;

/**
 *
 * This interface handles service for ratings.
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Karen
 *
 */
public interface RatingService {

    RecipeRatings findByRatingID(long ratingID);
    RecipeRatings[] findByRecipeID(long recipeID);
    RecipeRatings saveRating(RecipeRatings newRating);
    void delete(RecipeRatings recipeRatings);
}
