
package danilem.app.com.testtaskposts.repository.models.responses.post_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvatarImage {

    @SerializedName("url_medium")
    @Expose
    private String urlMedium;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("url_large")
    @Expose
    private String urlLarge;
    @SerializedName("url_small")
    @Expose
    private String urlSmall;
    @SerializedName("mentioned_users_count")
    @Expose
    private Integer mentionedUsersCount;

    public String getUrlMedium() {
        return urlMedium;
    }

    public void setUrlMedium(String urlMedium) {
        this.urlMedium = urlMedium;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlLarge() {
        return urlLarge;
    }

    public void setUrlLarge(String urlLarge) {
        this.urlLarge = urlLarge;
    }

    public String getUrlSmall() {
        return urlSmall;
    }

    public void setUrlSmall(String urlSmall) {
        this.urlSmall = urlSmall;
    }

    public Integer getMentionedUsersCount() {
        return mentionedUsersCount;
    }

    public void setMentionedUsersCount(Integer mentionedUsersCount) {
        this.mentionedUsersCount = mentionedUsersCount;
    }

}
