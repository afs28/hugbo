package is.hi.hbv501g.hugbo.Controllers;

import is.hi.hbv501g.hugbo.Persistence.Entities.RecipeUser;
import is.hi.hbv501g.hugbo.Services.RecipeUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class RecipeUserController {

    //private RecipeUserRepository recipeUserRepository;
    private RecipeUserService recipeUserService;

    // checking for "LoggedInUser" in session
    // this is used to check if the user is logged in
    private boolean isLoggedIn(HttpSession session, Model model) {
        RecipeUser sessionUser = (RecipeUser) session.getAttribute("LoggedInUser");
        if(sessionUser  != null){
            model.addAttribute("LoggedInUser", sessionUser);
            return true;
        }
        return false;
    }

    // display profile if logged in
    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public String getProfile(HttpSession session, Model model) {
        if (isLoggedIn(session, model)) {
            return "profile";
        }
        return "redirect:/login";
    }

    // remove LoggedInUser from session (sign out)
    @RequestMapping(value="/logout", method = RequestMethod.POST)
    public String logout(HttpSession session, Model model) {
        if (isLoggedIn(session, model)) {
            session.removeAttribute("LoggedInUser");

        }
        return "redirect:/login";
    }

    // change password, needs old password as confirmation
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
