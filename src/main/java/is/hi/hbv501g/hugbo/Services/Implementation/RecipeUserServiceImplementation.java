package is.hi.hbv501g.hugbo.Services.Implementation;

import is.hi.hbv501g.hugbo.Persistence.Entities.RecipeUser;
import is.hi.hbv501g.hugbo.Persistence.Repositories.RecipeUserRepository;
import is.hi.hbv501g.hugbo.Services.RecipeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The implementation class for the RecipeUserService.
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Karen
 *
 */
@Service
public class RecipeUserServiceImplementation implements RecipeUserService {
    private RecipeUserRepository recipeUserRepository;

    @Autowired
    public RecipeUserServiceImplementation(RecipeUserRepository recipeUserRepository){
        this.recipeUserRepository = recipeUserRepository;
    }

    /**
     * This function saves the user to the database.
     * @param recipeUser to be saved.
     * @return saved recipeUser.
     */
    @Override
    public RecipeUser save(RecipeUser recipeUser){
        return recipeUserRepository.save(recipeUser);
    }

    /**
     * This function deletes the user from the database. Was thought to be used at first
     * but turned out it wasn't, will be deleted.
     * @param recipeUser to be deleted.
     */
    @Override
    public void delete(RecipeUser recipeUser){
        recipeUserRepository.delete(recipeUser);
    }

    /**
     * This function enables the user to change the password to their account.
     * @param recipeUser whose password will be changed.
     * @param newPassword to the recipeUser account.
     */
    @Override
    public void changePassword(RecipeUser recipeUser, String newPassword) {
        recipeUser.setRecipeUserPassword(newPassword);
    }


    @Override
    public List<RecipeUser> findAll(){
        return recipeUserRepository.findAll();
    }


    @Override
    public RecipeUser findByRecipeUsername(String recipeUsername){
        return recipeUserRepository.findByRecipeUsername(recipeUsername);
    }

    @Override
    public RecipeUser login(RecipeUser recipeUser){
        RecipeUser doesExists = findByRecipeUsername(recipeUser.getRecipeUsername());
        if(doesExists != null) {
            if(doesExists.getRecipeUserPassword().equals(recipeUser.getRecipeUserPassword()));
                return doesExists;
        }
        return null;
    }
    @Override
    public RecipeUser findByRecipeUserID(long id) {
        return recipeUserRepository.findByRecipeUserID(id);
    }
}
