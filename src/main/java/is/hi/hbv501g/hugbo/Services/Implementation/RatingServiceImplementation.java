package is.hi.hbv501g.hugbo.Services.Implementation;

import is.hi.hbv501g.hugbo.Persistence.Entities.RecipeRatings;
import is.hi.hbv501g.hugbo.Persistence.Repositories.CommentRepository;
import is.hi.hbv501g.hugbo.Persistence.Repositories.RatingRepository;
import is.hi.hbv501g.hugbo.Persistence.Repositories.RecipeRepository;
import is.hi.hbv501g.hugbo.Persistence.Repositories.RecipeUserRepository;
import is.hi.hbv501g.hugbo.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class implements the Rating Service interface.
 * It's meant to help with finding by using ID, as well as 'save' and 'delete'.
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Karen
 */
@Service
public class RatingServiceImplementation implements RatingService {
    /**
     * Attributes
     */
    @Autowired
    RatingRepository ratingRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    RecipeUserRepository recipeUserRepository;

    /**
     * This method returns a rating ID.
     *
     * @param ratingID
     * @return ratingRepository.findByRatingID(ratingID)
     */
    @Override
    public RecipeRatings findByRatingID(long ratingID) {
        return ratingRepository.findByRatingID(ratingID);
    }

    /**
     * This method returns a recipe ID.
     *
     * @param recipeID
     * @return ratingRepository.findByRecipeID(recipeID)
     */
    @Override
    public RecipeRatings[] findByRecipeID(long recipeID) { return ratingRepository.findByRecipeID(recipeID);
    }

    /**
     * This method is for saving a rating.
     *
     * @param newRating
     * @return ratingRepository.save(newRating)
     */
    @Override
    public RecipeRatings saveRating(RecipeRatings newRating) {
        return ratingRepository.save(newRating);
    }

    /**
     * This method is for deleting a rating.
     * @param recipeRatings
     */
    @Override
    public void delete(RecipeRatings recipeRatings){
        ratingRepository.delete(recipeRatings);
    }
}
