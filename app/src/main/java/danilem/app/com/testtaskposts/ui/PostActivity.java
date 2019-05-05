package danilem.app.com.testtaskposts.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dima.inrating_post.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import danilem.app.com.testtaskposts.repository.models.CategoryModel;
import danilem.app.com.testtaskposts.repository.models.responses.model.User;
import danilem.app.com.testtaskposts.repository.models.responses.post_model.Post;
import danilem.app.com.testtaskposts.repository.Repository;
import danilem.app.com.testtaskposts.repository.retrofit.RetroNetwork;

public class PostActivity extends AppCompatActivity implements MvpView {

    private ArrayList<CategoryModel> categoryModels = new ArrayList<>();
    private ArrayList<User> likers = new ArrayList<>();
    private ArrayList<User> commentators = new ArrayList<>();
    private ArrayList<User> reposters = new ArrayList<>();
    private ArrayList<User> mentions = new ArrayList<>();
    private PostRecyclerAdapter adapter;
    private PostActivityPresenter presenter;

    @BindView(R.id.rv) RecyclerView rv;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_);
        ButterKnife.bind(this);

        createCategories();
        initPresenter();

        rv.setHasFixedSize(true);
        adapter = new PostRecyclerAdapter(this, categoryModels, likers, commentators, mentions, reposters);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(adapter);
    }

    void initPresenter(){
        presenter = new PostActivityPresenter(new Repository(new RetroNetwork()));
        presenter.onAttach(this);
        presenter.getPost(RetroNetwork.slug);
        presenter.getLikers(RetroNetwork.id);
        presenter.getCommentators(RetroNetwork.id);
        presenter.getReposters(RetroNetwork.id);
        presenter.getMentions(RetroNetwork.id);
    }

    private void createCategories(){
        for (int i = 0; i < 6; i++) {
            categoryModels.add(new CategoryModel());
        }
        categoryModels.get(0).setName("Просмотры");
        categoryModels.get(1).setName("Лайки");
        categoryModels.get(2).setName("Комментаторы");
        categoryModels.get(3).setName("Отметки");
        categoryModels.get(4).setName("Репосты");
        categoryModels.get(5).setName("Закладки");
        categoryModels.get(1).setList(likers);
        categoryModels.get(2).setList(commentators);
        categoryModels.get(3).setList(mentions);
        categoryModels.get(4).setList(reposters);
    }

    @Override
    public void updatePost(Post post) {
        categoryModels.get(0).setNumber(post.getViewsCount());
        categoryModels.get(1).setNumber(post.getLikesCount());
        categoryModels.get(2).setNumber(post.getCommentsCount());
        categoryModels.get(3).setNumber(0);
        categoryModels.get(4).setNumber(post.getRepostsCount());
        categoryModels.get(5).setNumber(post.getBookmarksCount());
    }

    @Override
    public void updateLikers(ArrayList<User> likers) {
        this.likers.addAll(likers);
    }

    @Override
    public void updateCommentators(ArrayList<User> commentators) {
        this.commentators.addAll(commentators);
    }

    @Override
    public void updateReposters(ArrayList<User> reposters) {
        this.reposters.addAll(reposters);
    }

    @Override
    public void updateMentions(ArrayList<User> mentions) {
        this.mentions.addAll(mentions);
    }

    @Override
    public void updateUi() {
        adapter.notifyDataSetChanged();
        adapter.itemListDataAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }
}
