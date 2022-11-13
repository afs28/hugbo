package is.hi.hbv501g.hugbo.Persistence.Repositories;
import is.hi.hbv501g.hugbo.Persistence.Entities.RecipeUser;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 * The recipe user repository.
 * @Authors: AFS
 *
 */

public interface RecipeUserRepository extends JpaRepository<RecipeUser, Long> {

    RecipeUser save(RecipeUser recipeUser);
    void delete(RecipeUser recipeUser);
    List<RecipeUser> findAll();
    RecipeUser findByRecipeUsername(String recipeUsername);

    RecipeUser findByRecipeUserID(Long id);
}
