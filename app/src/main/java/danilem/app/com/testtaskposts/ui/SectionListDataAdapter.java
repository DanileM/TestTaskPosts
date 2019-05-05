package danilem.app.com.testtaskposts.ui;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dima.inrating_post.R;
import danilem.app.com.testtaskposts.repository.models.responses.model.User;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<User> itemsList;
    private Context mContext;

    public SectionListDataAdapter(Context context, ArrayList<User> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_single_elem_card, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {
        User user = itemsList.get(i);
        holder.tvItem.setText(user.getName());
        PostActivityPresenter.imageDownload(user.getAvatar().getUrl(),holder.ivItem);

    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_item) TextView tvItem;
        @BindView(R.id.iv_item) ImageView ivItem;

        public SingleItemRowHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
