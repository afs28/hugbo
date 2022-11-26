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
 * The main controller that handles recipes and users.
 * @Authors: AFS
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

    @RequestMapping(value = "/recipe", method = RequestMethod.GET)
    @ResponseBody
    public Model displayRecipe(HttpSession session, Model model, @RequestParam String id) {
        Recipe rep = recipeService.findByID(Long.parseLong(id));
        model.addAttribute("recipe", rep);
        model.addAttribute("id", id);
        session.setAttribute("id", id);

        model.addAttribute("recipecomment", commentService.findByRecipeID(Long.parseLong(id)));
        RecipeRatings[] temp = ratingService.findByRecipeID(Long.parseLong(id));
        System.out.println(temp);
        for (RecipeRatings t: temp) {
            System.out.println(t.getMyRating());
        }
        model.addAttribute("reciperating", ratingService.findByRecipeID(Long.parseLong(id)));

        return model;
    }

    @PostMapping("/submit")
    public String AddComment (HttpSession session, Model model, @RequestParam String recipeUsername, @RequestParam String recipeComment) {
        try {
            long id = Long.parseLong((String)session.getAttribute("id"));

            RecipeUser recipeUser = recipeUserService.findByRecipeUserID(id);
            RecipeComments newComment = new RecipeComments();
            System.out.println(newComment);

            newComment.setCommentID(0l); // why can't this be skipped????
            System.out.println(newComment.getCommentID());

            newComment.setMyComment(recipeComment);
            System.out.println(newComment.getMyComment());

            newComment.setNickname(recipeUsername);
            System.out.println(newComment.getNickname());

            newComment.setRecipeID(recipeUser.getRecipeUserID());
            System.out.println(newComment.getRecipeID());

            commentRepository.save(newComment);
        }catch (Exception e){
            System.out.println(e);
        }
        return "index";
        /*+ model.getAttribute("id");*/
    }

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