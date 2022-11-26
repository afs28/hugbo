package is.hi.hbv501g.hugbo.Controllers;


import is.hi.hbv501g.hugbo.Persistence.Entities.RecipeUser;
import is.hi.hbv501g.hugbo.Persistence.Repositories.RecipeUserRepository;
import is.hi.hbv501g.hugbo.Services.RecipeService;
import is.hi.hbv501g.hugbo.Services.RecipeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * this controller handles the login.html page
 * both displaying it as well as handling its calls to 'login' and 'signup'
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Karen
 */
@Controller
public class LoginController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    private RecipeUserRepository recipeUserRepository;

    @Autowired
    RecipeUserService recipeUserService;


    /*
        Notkun: s/loginPage
        Fyrir:  s er síðan sem að verkefnið er á.
                Það er notað GET skipun (á loginPage)
        Eftir:  skilar login/signup síðuni
     */
    // display login page
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpSession session, Model model, RecipeUser recipeUser) {
        return "login";
    }


    // login
    // if login is correct login and return to homepage and add "LoggedInUser" to session
    // (LoggedInUser is used as the check if the user is logged in)
    // otherwise return to login page
    @PostMapping("/login")
    public String login(RecipeUser recipeUser, BindingResult result, Model model, HttpSession session) {
        if(result.hasErrors()) {
            return "login";
        }
        RecipeUser exists = recipeUserService.login(recipeUser);
        if(exists != null) {
            session.setAttribute("LoggedInUser", exists);
            //model.addAttribute("LoggedInUser", exists);
            return "redirect:/";
        }
        return "login";
    }

    // signup
    // create new user if the username selected does not exist
    // otherwise return error
    @PostMapping("/signup")
    public String AddUser (RecipeUser recipeUser, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "login";
        }
        RecipeUser exists = recipeUserService.findByRecipeUsername(recipeUser.getRecipeUsername());
        if(exists == null) {
            recipeUserRepository.save(recipeUser);
            return "redirect:/";
        }
        return "login";
    }
}
