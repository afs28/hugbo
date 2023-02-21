package is.hi.hbv501g.hugbo.Controllers;

import is.hi.hbv501g.hugbo.Persistence.Entities.Recipe;
import is.hi.hbv501g.hugbo.Services.RecipeService;
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
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Karen
 *
 */

@RestController
public class RestHomeController {

    final RecipeService recipeService;

    public RestHomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/index")
    @ResponseBody
    public List<Recipe> getRecipes() {
        return recipeService.findAll();
    }

}
