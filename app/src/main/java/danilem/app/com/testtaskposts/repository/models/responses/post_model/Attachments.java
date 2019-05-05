
package danilem.app.com.testtaskposts.repository.models.responses.post_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Attachments {

    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("videos")
    @Expose
    private Object videos;
    @SerializedName("posts")
    @Expose
    private Object posts;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Object getVideos() {
        return videos;
    }

    public void setVideos(Object videos) {
        this.videos = videos;
    }

    public Object getPosts() {
        return posts;
    }

    public void setPosts(Object posts) {
        this.posts = posts;
    }

}
