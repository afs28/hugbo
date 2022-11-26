package is.hi.hbv501g.hugbo.Controllers;

import is.hi.hbv501g.hugbo.Persistence.Entities.RecipeUser;
import is.hi.hbv501g.hugbo.Services.RecipeUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
@Controller
public class RecipeUserController {

    /**
     * Attributes
     */
    private RecipeUserService recipeUserService;

    /**
     * This method checks if the User is logged-in.
     *
     * @param session
     * @param model
     * @return if true, then the User is logged in. If false, then the User has to log-in.
     */
    private boolean isLoggedIn(HttpSession session, Model model) {
        RecipeUser sessionUser = (RecipeUser) session.getAttribute("LoggedInUser");
        if(sessionUser  != null){
            model.addAttribute("LoggedInUser", sessionUser);
            return true;
        }
        return false;
    }

    /**
     * This method displays the profile but only if the User is logged-in.
     *
     * @param session
     * @param model
     * @return "redirect:/login"
     */
    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public String getProfile(HttpSession session, Model model) {
        if (isLoggedIn(session, model)) {
            return "profile";
        }
        return "redirect:/login";
    }

    /**
     * This method implements the logout function and helps a "logged-in User" sign out.
     *
     * @param session
     * @param model
     * @return "redirect:/login"
     */
    @RequestMapping(value="/logout", method = RequestMethod.POST)
    public String logout(HttpSession session, Model model) {
        if (isLoggedIn(session, model)) {
            session.removeAttribute("LoggedInUser");
        }
        return "redirect:/login";
    }

    /**
     *
     * This method is for changing the User's password. It's currently not working.
     * @param oldPassword
     * @param newPassword
     * @param model
     * @param session
     * @return "profile"
     */
    @RequestMapping(value = "/profile/changePassword", method = RequestMethod.POST)
    public String changePassword(@RequestParam String oldPassword, @RequestParam String newPassword, Model model, HttpSession session) {
        model.addAttribute("passerror", "I would change your password, but it's not working... q.q");

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
        return "profile";
    }
}
