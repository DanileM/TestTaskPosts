package danilem.app.com.testtaskposts.repository.picasso;

import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PicassoNetwork {
    public static void imageDownload(String url,ImageView image){
        Picasso.get().load(url).into(image, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

            }
        });

    }
}
