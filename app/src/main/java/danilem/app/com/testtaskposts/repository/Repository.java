package danilem.app.com.testtaskposts.repository;

import android.widget.ImageView;

import danilem.app.com.testtaskposts.repository.models.responses.model.Model;
import danilem.app.com.testtaskposts.repository.models.responses.post_model.Post;
import danilem.app.com.testtaskposts.repository.picasso.PicassoNetwork;
import danilem.app.com.testtaskposts.repository.retrofit.RetroNetwork;
import retrofit2.Call;

public class Repository {

    private RetroNetwork retroNetwork;

    public Repository(RetroNetwork retroNetwork) {
        this.retroNetwork = retroNetwork;
    }

    public Call<Post> getPost(String slug){
        return retroNetwork.getPost(slug);
    }

    public Call<Model> getLikers(String id){
        return retroNetwork.getLikers(id);
    }

    public Call<Model> getReposters(String id){
        return retroNetwork.getReposters(id);
    }

    public Call<Model> getCommentators(String id){
        return retroNetwork.getCommentators(id);
    }

    public Call<Model> getMentions(String id){
        return retroNetwork.getMentions(id);
    }

    public static void imageDownload(String url,ImageView image){
        PicassoNetwork.imageDownload(url,image);
    }
}
