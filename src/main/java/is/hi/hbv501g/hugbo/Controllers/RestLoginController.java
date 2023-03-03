package is.hi.hbv501g.hugbo.Controllers;


import is.hi.hbv501g.hugbo.Persistence.Entities.RecipeUser;
import is.hi.hbv501g.hugbo.Persistence.Repositories.RecipeUserRepository;
import is.hi.hbv501g.hugbo.Services.RecipeService;
import is.hi.hbv501g.hugbo.Services.RecipeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * this controller handles the login.html page
 * both displaying it and handling its calls to 'login' and 'signup'
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Karen
 */
@RestController
@RequestMapping("/api")
public class RestLoginController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    private RecipeUserRepository recipeUserRepository;

    @Autowired
    RecipeUserService recipeUserService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RecipeUser recipeUser, HttpSession session) {
        RecipeUser exists = recipeUserService.login(recipeUser);
        if (exists != null) {
            session.setAttribute("LoggedInUser", exists);
            return ResponseEntity.ok().body(exists);
        }
        return ResponseEntity.badRequest().body("Invalid login credentials");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody RecipeUser recipeUser) {
        RecipeUser exists = recipeUserService.findByRecipeUsername(recipeUser.getRecipeUsername());
        if (exists == null) {
            recipeUserRepository.save(recipeUser);
            return ResponseEntity.ok().body("User created successfully");
        }
        return ResponseEntity.badRequest().body("Username already exists");
    }
}
