package is.hi.hbv501g.hugbo.Services.Implementation;

import is.hi.hbv501g.hugbo.Persistence.Entities.RecipeComments;
import is.hi.hbv501g.hugbo.Persistence.Repositories.CommentRepository;
import is.hi.hbv501g.hugbo.Persistence.Repositories.RecipeRepository;
import is.hi.hbv501g.hugbo.Persistence.Repositories.RecipeUserRepository;
import is.hi.hbv501g.hugbo.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class implements the Comment Service interface.
 * It's meant to help with finding by using ID, as well as 'save' and 'delete'.
 *
 * @author Arnar Freyr
 * @author Birgitta Yr
 * @author Heba Solveig
 * @author Hrefna Karen
 */
@Service
public class CommentServiceImplementation implements CommentService {
    /**
     * Attributes
     */
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    RecipeUserRepository recipeUserRepository;

    /**
     * This method returns the comment ID.
     *
     * @param commentID
     * @return commentRepository.findByCommentID(commentID)
     */
    @Override
    public RecipeComments findByCommentID(long commentID) {
        return commentRepository.findByCommentID(commentID);
    }

    /**
     * This method returns the recipe ID.
     *
     * @param recipeID
     * @return commentRepository.findByRecipeID(recipeID)
     */
    @Override
    public RecipeComments[] findByRecipeID(long recipeID) { return commentRepository.findByRecipeID(recipeID);
    }

    /**
     * This method is for saving a comment.
     *
     * @param newComment
     * @return commentRepository.save(newComment)
     */
    @Override
    public RecipeComments saveComment(RecipeComments newComment) {
        return commentRepository.save(newComment);
    }

    /**
     * This method is for deleting a comment.
     *
     * @param recipeComments
     */
    @Override
    public void delete(RecipeComments recipeComments){
        commentRepository.delete(recipeComments);
    }
}
