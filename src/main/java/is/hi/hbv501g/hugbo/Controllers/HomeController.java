package is.hi.hbv501g.hugbo.Controllers;

import is.hi.hbv501g.hugbo.Persistence.Entities.Recipe;
import is.hi.hbv501g.hugbo.Services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import is.hi.hbv501g.hugbo.Controllers.RecipeController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * This controller handles the index page, shows the list of
 * recipes that have been added to the database in column kind
 * of view and enables editing recipes.
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Karen
 *
 */

@Controller
public class HomeController {

    final RecipeService recipeService;

    public HomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    /**
     * This function sets up the recipes on the index template
     * after fetching them from the database.
     *
     * @param model of the template.
     * @return to index.
     */
    @GetMapping("/")
    public String createHome(Model model) {
        model.addAttribute("recipe", recipeService.findAll());
        return "index";
    }

    /**
     * This function takes you to another template where you can fill
     * out the form for your recipe that you wish to add to the database.
     *
     * @param model of the template.
     * @return to formRecipe.
     */
    @GetMapping(value = "/create")
    public String createRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "formRecipe";
    }

    /**
     * This function saves the recipe you've added to the database and returns you to
     * a previous template.
     *
     * @param model of the template.
     * @param recipe you're adding.
     * @return to previous template.
     */
    @PostMapping(value = "/create")
    public String saveRecipe(Model model, Recipe recipe) {
        model.addAttribute("recipe", recipeService.saveRecipe(recipe));
        return "redirect:/";
    }

    /**
     * This function takes you to the edit-recipe template for the recipe you're
     * currently viewing.
     *
     * @param session of current recipe.
     * @param model of the template.
     * @return to editFormRecipe.
     */
    @RequestMapping(value="edit-recipe", method = RequestMethod.GET)
    public String displayEditARecipe(HttpSession session, Model model) {
        return "editFormRecipe";
    }

    /**
     * This function handles the process of editing a recipe. It replaces previous parameters
     * with the new ones after filling out the form.
     *
     * @param session of current recipe.
     * @param model of the template.
     * @param request new parameters.
     * @return to index.
     */
    @RequestMapping(value="edit-recipe", method = RequestMethod.POST)
    public String editARecipe(HttpSession session, Model model, HttpServletRequest request) {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String difficultyLevel = request.getParameter("difficultyLevel");
        String allergyFactors = request.getParameter("allergyFactors");
        Recipe recipe = recipeService.editARecipe((Recipe)session.getAttribute("recipe"),title,
                description, difficultyLevel, allergyFactors);
        recipeService.saveRecipe(recipe);

        return "redirect:/";
    }

}
