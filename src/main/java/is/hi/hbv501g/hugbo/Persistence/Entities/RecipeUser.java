package is.hi.hbv501g.hugbo.Persistence.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;

/**
 * The main recipe user class, getters and setters.
 * the @column is used to make sure it goes to the right column in the database
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Karen
 */

@Entity
@Table(name="recipeuser")
public class RecipeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipeuserid")
    private long recipeUserID;
    @NotNull
    @Column(name = "recipeusername")
    @JsonProperty("recipeUsername")
    private String recipeUsername;
    @NotNull
    @Column(name = "recipeuserpassword")
    @JsonProperty("recipeUserPassword")
    private String recipeUserPassword;

    public RecipeUser() {
        super();
        // TODO Auto-generated constructor stub
    }
    public RecipeUser(String recipeUsername, String recipeUserPassword){
        super();
        this.recipeUsername = recipeUsername;
        this.recipeUserPassword = recipeUserPassword;
    }

    public RecipeUser(long recipeUserID){
        this.recipeUserID = recipeUserID;
    }

    public long getRecipeUserID() {
        return recipeUserID;
    }

    public void setRecipeUserID(long recipeUserID) {
        this.recipeUserID = recipeUserID;
    }
    public String getRecipeUsername() {
        return recipeUsername;
    }

    public void setRecipeUsername(String recipeUsername) {
        this.recipeUsername = recipeUsername;
    }
    public String getRecipeUserPassword() {
        return recipeUserPassword;
    }

    public void setRecipeUserPassword(String recipeUserPassword) {
        this.recipeUserPassword = recipeUserPassword;
    }

}
