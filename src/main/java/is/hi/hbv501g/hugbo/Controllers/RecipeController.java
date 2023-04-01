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

@Controller
@SessionAttributes("recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private RatingService ratingService;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private RecipeUserService recipeUserService;

    /**
     * This function takes you to a different template which includes a more comfortable
     * view of the recipe you've chosen.
     *
     * @param session of the recipe.
     * @param model of the template.
     * @param id of the recipe.
     * @return the selected recipe.
     */
    @RequestMapping(value = "/recipe", method = RequestMethod.GET)
    @ResponseBody
    public Model displayRecipe(HttpSession session, Model model, @RequestParam String id) {
        try {
            long parsedId = Long.parseLong(id);
            Recipe rep = recipeService.findByID(parsedId);
            model.addAttribute("recipe", rep);
            model.addAttribute("id", id);
            session.setAttribute("id", id);

            model.addAttribute("recipecomment", commentService.findByRecipeID(parsedId));
            model.addAttribute("reciperating", ratingService.findByRecipeID(parsedId));
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        return model;
    }

    /**
     * This function allows logged in users to add comments to the recipe
     * that they're currently viewing.
     *
     * @param session of the recipe.
     * @param model of the template.
     * @param recipeUsername to enable commenting.
     * @param recipeComment to save.
     * @return to index.
     */
    @PostMapping("/submit")
    public String AddComment(HttpSession session, Model model, @RequestParam String recipeUsername, @RequestParam String recipeComment) {
        try {
            long id = Long.parseLong((String) session.getAttribute("id"));
            RecipeUser loggedInUser = null;

            if (RecipeUserController.isLoggedIn(session, model)) {
                loggedInUser = (RecipeUser) session.getAttribute("LoggedInUser");
            }

            if (loggedInUser != null) {
                RecipeComments newComment = new RecipeComments();
                newComment.setCommentID(0l);
                newComment.setMyComment(recipeComment);
                newComment.setNickname(recipeUsername);
                newComment.setRecipeID(id); // Use the 'id' variable for the recipeID attribute
                commentRepository.save(newComment);
            } else {
                // Handle the case where the loggedInUser is not found, e.g., display an error message
                System.out.println("User not found");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "index";
    }


    /**
     * This function allows the user to add their own rating to the recipe
     * they're currently viewing.
     *
     * @param session of the recipe.
     * @param model of the template.
     * @param recipeUsername to enable rating.
     * @param recipeRating to be added.
     * @return to index.
     */
    @PostMapping("/Rsubmit")
    public String AddRating (HttpSession session, Model model, @RequestParam String recipeUsername, @RequestParam String recipeRating) {
        try {
            long id = Long.parseLong((String)session.getAttribute("id"));
            RecipeRatings newRating = new RecipeRatings();
            newRating.setRatingsID(0l); // why can't this be skipped????
            System.out.println(recipeRating);
            newRating.setMyRating(Double.parseDouble(recipeRating));
            System.out.println(newRating.getMyRating());
            newRating.setNickname(recipeUsername);
            newRating.setRecipeID(id);
            ratingRepository.save(newRating);
        }catch (Exception e){
            System.out.println(e);
        }
        return "index";
        /*+ model.getAttribute("id");*/

    }


}