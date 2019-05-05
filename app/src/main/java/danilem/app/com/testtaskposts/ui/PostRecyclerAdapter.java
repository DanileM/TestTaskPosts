package danilem.app.com.testtaskposts.ui;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dima.inrating_post.R;
import danilem.app.com.testtaskposts.repository.models.CategoryModel;
import danilem.app.com.testtaskposts.repository.models.responses.model.User;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostRecyclerAdapter extends RecyclerView.Adapter<PostRecyclerAdapter.ItemRowHolder> {

    private ArrayList<CategoryModel> dataList;
    private Context mContext;
    public SectionListDataAdapter itemListDataAdapter;
    private ArrayList<User> likers;
    private ArrayList<User> commentators;
    private ArrayList<User> mentions;
    private ArrayList<User> reposters;

    public PostRecyclerAdapter(Context context, ArrayList<CategoryModel> dataList,
                               ArrayList<User> likers, ArrayList<User> commentators,
                               ArrayList<User> mentions, ArrayList<User> reposters) {
        this.dataList = dataList;
        mContext = context;
        this.likers = likers;
        this.commentators = commentators;
        this.mentions = mentions;
        this.reposters = reposters;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_section_card, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder itemRowHolder, int i) {

        final String sectionName = dataList.get(i).getName();
        final int number = dataList.get(i).getNumber();
        int expand = number - 5  > 0 ? number - 5 : 0;

        itemRowHolder.tvTitleLeft.setText(sectionName + " " + String.valueOf(number));
        itemRowHolder.tvTitleRight.setText(String.valueOf(expand));

        switcher(i,itemRowHolder);

        itemRowHolder.rvList.setHasFixedSize(true);
        itemRowHolder.rvList.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        itemRowHolder.rvList.setAdapter(itemListDataAdapter);

    }

    private void switcher(int i,ItemRowHolder itemRowHolder) {
        switch (i){
            case 0:
                itemListDataAdapter = new SectionListDataAdapter(mContext,null);
                itemRowHolder.ivLeft.setBackground(mContext.getDrawable(R.drawable.baseline_visibility_black_18dp));
                itemRowHolder.tvTitleRight.setText("");
                break;
            case 1:
                itemListDataAdapter = new SectionListDataAdapter(mContext,likers);
                itemRowHolder.ivLeft.setBackground(mContext.getDrawable(R.drawable.baseline_thumb_up_black_18dp));
                break;
            case 2:
                itemListDataAdapter = new SectionListDataAdapter(mContext,commentators);
                itemRowHolder.ivLeft.setBackground(mContext.getDrawable(R.drawable.baseline_chat_bubble_outline_black_18dp));
                break;
            case 3:
                itemListDataAdapter = new SectionListDataAdapter(mContext,mentions);
                itemRowHolder.ivLeft.setBackground(mContext.getDrawable(R.drawable.baseline_person_outline_black_18dp));
                itemRowHolder.tvTitleRight.setText(String.valueOf(mentions.size()));
                break;
            case 4:
                itemListDataAdapter = new SectionListDataAdapter(mContext,reposters);
                itemRowHolder.ivLeft.setBackground(mContext.getDrawable(R.drawable.baseline_share_black_18dp));
                break;
            case 5:
                itemListDataAdapter = new SectionListDataAdapter(mContext,null);
                itemRowHolder.ivLeft.setBackground(mContext.getDrawable(R.drawable.baseline_collections_bookmark_black_18dp));
                itemRowHolder.tvTitleRight.setText("");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title_left) TextView tvTitleLeft;
        @BindView(R.id.tv_title_right) TextView tvTitleRight;
        @BindView(R.id.iv_left) ImageView ivLeft;
        @BindView(R.id.iv_right) ImageView ivRight;
        @BindView(R.id.rv_list) RecyclerView rvList;

        private ItemRowHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}