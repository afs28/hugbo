package is.hi.hbv501g.hugbo.Services.Implementation;

import is.hi.hbv501g.hugbo.Persistence.Entities.Recipe;
import is.hi.hbv501g.hugbo.Persistence.Repositories.RecipeRepository;
import is.hi.hbv501g.hugbo.Persistence.Repositories.RecipeUserRepository;
import is.hi.hbv501g.hugbo.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The implementation class for the RecipeService.
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Karen
 *
 */
@Service
public class RecipeServiceImplementation implements RecipeService {
    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeUserRepository recipeUserRepository;


    @Override
    public List<Recipe> findAll(){
        return recipeRepository.findAll();
    }

    @Override
    public List<Recipe> findByTitle(String title) {
        return recipeRepository.findByTitle(title);
    }


    @Override
    public Recipe findByID(Long recipeID){
        return recipeRepository.findByRecipeID(recipeID);
    }

    /**
     * This function saves a recipe to the database.
     * @param recipe to be saved.
     * @return saved recipe.
     */
    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    /**
     * This function deletes a recipe from the database, was thought to be used at the beginning
     * of the project but wasn't in the end. To be deleted!
     * @param recipe to be deleted.
     */
    @Override
    public void delete(Recipe recipe){
        recipeRepository.delete(recipe);
    }

    /**
     * This function allows the user to edit an existing recipe in the database.
     * @param recipe to be edited.
     * @param title to be edited.
     * @param description to be edited.
     * @param difficultyLevel to be edited.
     * @param allergyFactors to be edited.
     * @return edited recipe.
     */
    @Override
    public Recipe editARecipe(Recipe recipe, String title, String description, String difficultyLevel, String allergyFactors) {
        recipe.setTitle(title);
        recipe.setDescription(description);
        recipe.setDifficultyLevel(difficultyLevel);
        recipe.setAllergyFactors(allergyFactors);
        return recipeRepository.save(recipe);
    }
}
