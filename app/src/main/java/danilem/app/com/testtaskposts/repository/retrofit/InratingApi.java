package danilem.app.com.testtaskposts.repository.retrofit;

import danilem.app.com.testtaskposts.repository.models.responses.model.Model;
import danilem.app.com.testtaskposts.repository.models.responses.post_model.Post;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface InratingApi {

    @POST("users/posts/get")
    Call<Post> getPost(@Query("slug") String slug);

    @POST("users/posts/likers/all")
    Call<Model> getLikers(@Query("id") String id);

    @POST("users/posts/reposters/all")
    Call<Model> getReposters(@Query("id") String id);

    @POST("users/posts/commentators/all")
    Call<Model> getCommentators(@Query("id") String id);

    @POST("users/posts/mentions/all")
    Call<Model> getMentions(@Query("id") String id);

}
