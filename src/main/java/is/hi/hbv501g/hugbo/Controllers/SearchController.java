package is.hi.hbv501g.hugbo.Controllers;

import is.hi.hbv501g.hugbo.Persistence.Entities.Recipe;
import is.hi.hbv501g.hugbo.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller used to handle the Search function. But it's currently not being used.
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Karen
 */
@RestController
public class SearchController {

    /**
     * Attributes
     */
    @Autowired
    private RecipeService recipeService;

    /**
     * This method was meant to be our search method, but only worked for exact titles.
     *
     * @param toSearch
     * @return recipeService.findByTitle(toSearch)
     */
    @RequestMapping(value="/search", method = RequestMethod.POST)
    public Iterable<Recipe> oldSearch (@RequestParam String toSearch) {
        return recipeService.findByTitle(toSearch);
    }
}
