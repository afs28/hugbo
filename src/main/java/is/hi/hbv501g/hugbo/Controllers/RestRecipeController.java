package is.hi.hbv501g.hugbo.Controllers;


import is.hi.hbv501g.hugbo.Persistence.Entities.Recipe;
import is.hi.hbv501g.hugbo.Persistence.Entities.RecipeComments;
import is.hi.hbv501g.hugbo.Persistence.Entities.RecipeRatings;
import is.hi.hbv501g.hugbo.Persistence.Entities.RecipeUser;
import is.hi.hbv501g.hugbo.Persistence.Repositories.CommentRepository;
import is.hi.hbv501g.hugbo.Persistence.Repositories.RatingRepository;
import is.hi.hbv501g.hugbo.Services.CommentService;
import is.hi.hbv501g.hugbo.Services.RatingService;
import is.hi.hbv501g.hugbo.Services.RecipeService;
import is.hi.hbv501g.hugbo.Services.RecipeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * This controller handles most things related to the recipe
 * entity itself!
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Karen
 *
 */

@RestController
@RequestMapping("/api")
@SessionAttributes("recipe")
public class RestRecipeController {
    private final RecipeService recipeService;
    private final CommentService commentService;
    private final RatingService ratingService;
    private final CommentRepository commentRepository;
    private final RatingRepository ratingRepository;
    private final RecipeUserService recipeUserService;

    public RestRecipeController(RecipeService recipeService, CommentService commentService,
                                RatingService ratingService, CommentRepository commentRepository,
                                RatingRepository ratingRepository, RecipeUserService recipeUserService) {
        this.recipeService = recipeService;
        this.commentService = commentService;
        this.ratingService = ratingService;
        this.commentRepository = commentRepository;
        this.ratingRepository = ratingRepository;
        this.recipeUserService = recipeUserService;
    }

    /**
     * This function takes you to a different template which includes a more comfortable
     * view of the recipe you've chosen.
     *
     * @param id of the recipe.
     * @return the selected recipe.
     */


    @GetMapping("/{id}")
    public Map<String, Object> displayRecipe(@PathVariable Long id) {
        Recipe recipe = recipeService.findByID(id);
        List<RecipeComments> comments = Arrays.asList(commentService.findByRecipeID(id));
        List<RecipeRatings> ratings = Arrays.asList(ratingService.findByRecipeID(id));

        Map<String, Object> response = new HashMap<>();
        response.put("recipe", recipe);
        response.put("comments", comments);
        response.put("ratings", ratings);
        return response;
    }


    @PostMapping("/{id}/comments")
    public Recipe addComment(@PathVariable Long id, @RequestBody RecipeComments recipeComment) {
        RecipeUser recipeUser = recipeUserService.findByRecipeUserID(id);
        recipeComment.setRecipeID(recipeUser.getRecipeUserID());
        commentRepository.save(recipeComment);
        return recipeService.findByID(id);
    }



    @PostMapping("/{id}/ratings")
    public Recipe addRating(@PathVariable Long id, @RequestBody RecipeRatings recipeRatings) {
        recipeRatings.setRecipeID(id);
        ratingRepository.save(recipeRatings);
        return recipeService.findByID(id);
    }

}