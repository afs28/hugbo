package is.hi.hbv501g.hugbo.Persistence.Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

/**
 * The main recipe rating class, getters and setters.
 * the @column is used to make sure it goes to the right column in the database
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Karen
 */

@Entity
@Table(name="reciperating")
public class RecipeRatings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratingid")
    private Long ratingID;

    @Column(name = "myrating")
    private Double myRating;

    @Column(name = "nickname")
    private String nickname;

    @NotNull
    @Column(name = "recipeid")
    private Long recipeID;

    public void setRatingsID(Long ratingsID) {
        this.ratingID = ratingsID;
    }

    public Long getRatingsID() {
        return ratingID;
    }

    public void setMyRating(Double recipeRating) {
        this.myRating = recipeRating;
    }
    public Double getMyRating() {
        return myRating;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
    public void setRecipeID(Long recipeID){
        this.recipeID = recipeID;
    }
    public Long getRecipeID() {
        return recipeID;
    }
}