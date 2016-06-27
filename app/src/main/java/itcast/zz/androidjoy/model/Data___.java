package itcast.zz.androidjoy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data___ {

    @SerializedName("storyBrief")
    @Expose
    private String storyBrief;
    @SerializedName("storyMoreLink")
    @Expose
    private String storyMoreLink;

    /**
     * @return The storyBrief
     */
    public String getStoryBrief() {
        return storyBrief;
    }

    /**
     * @param storyBrief The storyBrief
     */
    public void setStoryBrief(String storyBrief) {
        this.storyBrief = storyBrief;
    }

    /**
     * @return The storyMoreLink
     */
    public String getStoryMoreLink() {
        return storyMoreLink;
    }

    /**
     * @param storyMoreLink The storyMoreLink
     */
    public void setStoryMoreLink(String storyMoreLink) {
        this.storyMoreLink = storyMoreLink;
    }

}
