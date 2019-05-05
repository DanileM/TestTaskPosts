package danilem.app.com.testtaskposts.ui;

import java.util.ArrayList;

import danilem.app.com.testtaskposts.repository.models.responses.model.User;
import danilem.app.com.testtaskposts.repository.models.responses.post_model.Post;

public interface MvpView {

    void updatePost(Post post);
    void updateLikers(ArrayList<User> likers);
    void updateCommentators(ArrayList<User> commentators);
    void updateReposters(ArrayList<User> reposters);
    void updateMentions(ArrayList<User> mentions);
    void updateUi();

}
