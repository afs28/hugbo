package is.hi.hbv501g.hugbo.Controllers;

import is.hi.hbv501g.hugbo.Persistence.Entities.RecipeUser;
import is.hi.hbv501g.hugbo.Services.RecipeUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 *
 * This controller handles all the log-in functions as well as the log-out functions.
 * It displays the User profile but only if logged-in.
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Karen
 *
 */
@RestController
@RequestMapping("/api")
public class RestRecipeUserController {

    /**
     * Attributes
     */
    private RecipeUserService recipeUserService;

    /**
     * This method checks if the User is logged-in.
     *
     * @param session
     * @return ResponseEntity with boolean value indicating if the user is logged in or not
     */
    private ResponseEntity<Boolean> isLoggedIn(HttpSession session) {
        RecipeUser sessionUser = (RecipeUser) session.getAttribute("LoggedInUser");
        if(sessionUser != null){
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }

    /**
     * This method displays the profile but only if the User is logged-in.
     *
     * @param session
     * @return ModelAndView with view name "profile" if user is logged in, otherwise ModelAndView with view name "redirect:/login"
     */
    @GetMapping("/profile")
    public ModelAndView getProfile(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        if (isLoggedIn(session).getBody()) {
            modelAndView.setViewName("profile");
        } else {
            modelAndView.setViewName("redirect:/login");
        }
        return modelAndView;
    }

    /**
     * This method implements the logout function and helps a "logged-in User" sign out.
     *
     * @param session
     * @return ModelAndView with view name "redirect:/login"
     */
    @PostMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        if (isLoggedIn(session).getBody()) {
            session.removeAttribute("LoggedInUser");
        }
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }

    /**
     *
     * This method is for changing the User's password. It's currently not working.
     * @param oldPassword
     * @param newPassword
     * @param session
     * @return ModelAndView with view name "profile" and model attribute "passerror" indicating the password change status
     */
    @PostMapping("/profile/changePassword")
    public ModelAndView changePassword(@RequestParam String oldPassword, @RequestParam String newPassword, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");

        modelAndView.addObject("passerror", "I would change your password, but it's not working... q.q");
        /*
        if(false) {
            // "Old password did not match your current one!"
        }
        else if(false) {
            // "Your current has change changed (as you requested)."
        }
        else {
            // update password
            // "Password changed successfully!"
        }
        */
        return modelAndView;
    }
}
