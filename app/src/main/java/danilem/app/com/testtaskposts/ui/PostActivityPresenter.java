package danilem.app.com.testtaskposts.ui;

import android.widget.ImageView;

import java.util.ArrayList;

import danilem.app.com.testtaskposts.repository.models.responses.model.Model;
import danilem.app.com.testtaskposts.repository.models.responses.post_model.Post;
import danilem.app.com.testtaskposts.repository.Repository;
import danilem.app.com.testtaskposts.repository.picasso.PicassoNetwork;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivityPresenter {

    private MvpView mvpView;
    private Repository repository;

    public PostActivityPresenter(Repository repository) {
        this.repository = repository;
    }

    public void onAttach(MvpView mvpView) {
        this.mvpView = mvpView;
    }

    public void onDetach() {
        mvpView = null;
    }

    public boolean isViewAttached() {
        return mvpView != null;
    }


    public void getPost(String slug){
        repository.getPost(slug).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (isViewAttached()) {
                    mvpView.updatePost(response.body());
                    mvpView.updateUi();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    public void getLikers(String id){
        repository.getLikers(id).enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (isViewAttached()) {
                    mvpView.updateLikers(new ArrayList<>(response.body().getData()));
                    mvpView.updateUi();
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }

    public void getReposters(String id){
        repository.getReposters(id).enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (isViewAttached()) {
                    mvpView.updateReposters(new ArrayList<>(response.body().getData()));
                    mvpView.updateUi();
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }

    public void getCommentators(String id){
        repository.getCommentators(id).enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (isViewAttached()) {
                    mvpView.updateCommentators(new ArrayList<>(response.body().getData()));
                    mvpView.updateUi();
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }

    public void getMentions(String id){
        repository.getMentions(id).enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (isViewAttached()) {
                    mvpView.updateMentions(new ArrayList<>(response.body().getData()));
                    mvpView.updateUi();
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }

    public static void imageDownload(String url,ImageView image){
        PicassoNetwork.imageDownload(url,image);
    }
}
