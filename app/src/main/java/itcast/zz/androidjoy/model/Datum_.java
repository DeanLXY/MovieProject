package itcast.zz.androidjoy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum_ {

    @SerializedName("tvTitle")
    @Expose
    private String tvTitle;
    @SerializedName("iconaddress")
    @Expose
    private String iconaddress;
    @SerializedName("iconlinkUrl")
    @Expose
    private String iconlinkUrl;
    @SerializedName("m_iconlinkUrl")
    @Expose
    private String mIconlinkUrl;
    @SerializedName("playDate")
    @Expose
    private PlayDate playDate;
    @SerializedName("director")
    @Expose
    private Director director;
    @SerializedName("star")
    @Expose
    private Star star;
    @SerializedName("type")
    @Expose
    private Type type;
    @SerializedName("story")
    @Expose
    private Story story;
    @SerializedName("more")
    @Expose
    private More more;

    /**
     * @return The tvTitle
     */
    public String getTvTitle() {
        return tvTitle;
    }

    /**
     * @param tvTitle The tvTitle
     */
    public void setTvTitle(String tvTitle) {
        this.tvTitle = tvTitle;
    }

    /**
     * @return The iconaddress
     */
    public String getIconaddress() {
        return iconaddress;
    }

    /**
     * @param iconaddress The iconaddress
     */
    public void setIconaddress(String iconaddress) {
        this.iconaddress = iconaddress;
    }

    /**
     * @return The iconlinkUrl
     */
    public String getIconlinkUrl() {
        return iconlinkUrl;
    }

    /**
     * @param iconlinkUrl The iconlinkUrl
     */
    public void setIconlinkUrl(String iconlinkUrl) {
        this.iconlinkUrl = iconlinkUrl;
    }

    /**
     * @return The mIconlinkUrl
     */
    public String getMIconlinkUrl() {
        return mIconlinkUrl;
    }

    /**
     * @param mIconlinkUrl The m_iconlinkUrl
     */
    public void setMIconlinkUrl(String mIconlinkUrl) {
        this.mIconlinkUrl = mIconlinkUrl;
    }

    /**
     * @return The playDate
     */
    public PlayDate getPlayDate() {
        return playDate;
    }

    /**
     * @param playDate The playDate
     */
    public void setPlayDate(PlayDate playDate) {
        this.playDate = playDate;
    }

    /**
     * @return The director
     */
    public Director getDirector() {
        return director;
    }

    /**
     * @param director The director
     */
    public void setDirector(Director director) {
        this.director = director;
    }

    /**
     * @return The star
     */
    public Star getStar() {
        return star;
    }

    /**
     * @param star The star
     */
    public void setStar(Star star) {
        this.star = star;
    }

    /**
     * @return The type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @return The story
     */
    public Story getStory() {
        return story;
    }

    /**
     * @param story The story
     */
    public void setStory(Story story) {
        this.story = story;
    }

    /**
     * @return The more
     */
    public More getMore() {
        return more;
    }

    /**
     * @param more The more
     */
    public void setMore(More more) {
        this.more = more;
    }

}
