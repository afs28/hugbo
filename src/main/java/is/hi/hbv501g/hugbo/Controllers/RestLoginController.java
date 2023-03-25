package is.hi.hbv501g.hugbo.Controllers;


import is.hi.hbv501g.hugbo.Persistence.Entities.RecipeUser;
import is.hi.hbv501g.hugbo.Persistence.Repositories.RecipeUserRepository;
import is.hi.hbv501g.hugbo.Services.RecipeService;
import is.hi.hbv501g.hugbo.Services.RecipeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<RecipeUser> login(@RequestBody RecipeUser recipeUser) {
        RecipeUser exists = recipeUserService.login(recipeUser);
        if (exists != null) {
            return ResponseEntity.ok(exists);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody RecipeUser recipeUser) {
        RecipeUser exists = recipeUserService.findByRecipeUsername(recipeUser.getRecipeUsername());
        if (exists == null) {
            recipeUserRepository.save(recipeUser);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}