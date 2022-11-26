package is.hi.hbv501g.hugbo.Services;

import is.hi.hbv501g.hugbo.Persistence.Entities.RecipeUser;
import java.util.List;

/**
 *
 * This interface handles service for the recipe User.
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Karen
 *
 */
public interface RecipeUserService {
    RecipeUser save(RecipeUser recipeUser);
    void delete(RecipeUser recipeUser);
    void changePassword(RecipeUser recipeUser, String newPassword);
    List<RecipeUser> findAll();
    // find user by username
    RecipeUser findByRecipeUsername(String recipeUsername);
    RecipeUser login(RecipeUser recipeUser);
    RecipeUser findByRecipeUserID(long id);
}
