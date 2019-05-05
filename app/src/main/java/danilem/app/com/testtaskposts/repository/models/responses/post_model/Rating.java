
package danilem.app.com.testtaskposts.repository.models.responses.post_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {

    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("proportion")
    @Expose
    private Double proportion;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

}
