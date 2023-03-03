package is.hi.hbv501g.hugbo.Controllers;

import is.hi.hbv501g.hugbo.Persistence.Entities.Recipe;
import is.hi.hbv501g.hugbo.Services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import is.hi.hbv501g.hugbo.Controllers.RecipeController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * This Rest controller handles the index page, shows the list of
 * recipes that have been added to the database in column kind
 * of view and enables editing recipes.
 * Waking up railway!
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Karen
 *
 */

@RestController
@RequestMapping("/api")
public class RestHomeController {
    final RecipeService recipeService;

    public RestHomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    /**
     * This function sets up the recipes on the index template
     * after fetching them from the database.
     *
     * @return List of all recipes.
     */
    @GetMapping("/")
    public List<Recipe> getAllRecipes() {
        return recipeService.findAll();
    }

    /**
     * This function takes you to another template where you can fill
     * out the form for your recipe that you wish to add to the database.
     *
     * @param recipe you're adding.
     * @return added recipe.
     */
    @PostMapping(value = "/create")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.saveRecipe(recipe);
    }

    /**
     * This function handles the process of editing a recipe. It replaces previous parameters
     * with the new ones after filling out the form.
     *
     * @param recipeId of the recipe being edited.
     * @param recipe new parameters.
     * @return edited recipe.
     */
    @PutMapping(value="edit-recipe/{recipeId}")
    public Recipe editARecipe(@PathVariable Long recipeId, @RequestBody Recipe recipe) {
        Recipe currentRecipe = recipeService.findByID(recipeId);
        currentRecipe.setTitle(recipe.getTitle());
        currentRecipe.setDescription(recipe.getDescription());
        currentRecipe.setDifficultyLevel(recipe.getDifficultyLevel());
        currentRecipe.setAllergyFactors(recipe.getAllergyFactors());
        return recipeService.saveRecipe(currentRecipe);
    }

    /**
     * This function deletes a recipe with the given id.
     *
     * @param recipeId of the recipe being deleted.
     * @return HttpStatus.NO_CONTENT if the deletion is successful or HttpStatus.NOT_FOUND if the recipe is not found.
     */
    @DeleteMapping(value="delete-recipe/{recipeId}")
    public ResponseEntity deleteARecipe(@PathVariable Long recipeId) {
        Recipe recipe = recipeService.findByID(recipeId);
        if (recipe != null) {
            recipeService.delete(recipe);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
