package is.hi.hbv501g.hugbo.Persistence.Entities;

import javax.persistence.*;
import java.util.List;

/**
 * The famous recipe entity! Declarations, getters and setters.
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Karen
 *
 */
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipeid")
    private Long recipeID;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "difficultylevel")
    private String difficultyLevel;
    @Column(name = "allergyfactors")
    private String allergyFactors;
    @Column(name = "comments")
    private String comments;
    @Column(name = "ratings")
    private Double ratings;
    @Column(name = "imageofrecipe")
    private String imageOfRecipe;
    @Column(name = "fornumberofpeople")
    private Integer forNumberOfPeople;
    @Column(name = "preptime")
    private Integer prepTime;

    public Recipe(){
    }
    public Recipe(String title, String description, Long recipeID){
        this.title = title;
        this.description = description;
    }
    public Recipe(String title, String description){
        this.title = title;
        this.description = description;
    }
    public Recipe(Long recipeID){
        this.recipeID = recipeID;
    }
    public Long getRecipeID() {
        return recipeID;
    }
    public String getImageOfRecipe() {
        return imageOfRecipe;
    }
    public void setImageOfRecipe(String imageOfRecipe) {
        this.imageOfRecipe = imageOfRecipe;
    }
    public void setRecipeID(Long recipeID) {
        this.recipeID = recipeID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDifficultyLevel() {
        return difficultyLevel;
    }
    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
    public String getAllergyFactors() {
        return allergyFactors;
    }
    public void setAllergyFactors(String allergyFactors) {
        this.allergyFactors = allergyFactors;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comment) {
        this.comments = comment;
    }
    public Double getRatings() {
        return ratings;
    }
    public void setRatings(Double rating) {
        this.ratings = rating;
    }
    public Integer getForNumberOfPeople() {
        return forNumberOfPeople;
    }
    public void setForNumberOfPeople(Integer forNumberOfPeople) {
        this.forNumberOfPeople = forNumberOfPeople;
    }
    public Integer getPrepTime() {
        return prepTime;
    }
    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

}
