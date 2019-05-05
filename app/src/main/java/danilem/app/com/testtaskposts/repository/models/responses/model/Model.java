
package danilem.app.com.testtaskposts.repository.models.responses.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model {

    @SerializedName("data")
    @Expose
    private List<User> data = null;
    @SerializedName("mLink")
    @Expose
    private Link mLink;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    public Link getLink() {
        return mLink;
    }

    public void setLink(Link link) {
        this.mLink = link;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
