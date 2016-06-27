package itcast.zz.androidjoy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Story {

    @SerializedName("showname")
    @Expose
    private String showname;
    @SerializedName("data")
    @Expose
    private Data___ data;

    /**
     * @return The showname
     */
    public String getShowname() {
        return showname;
    }

    /**
     * @param showname The showname
     */
    public void setShowname(String showname) {
        this.showname = showname;
    }

    /**
     * @return The data
     */
    public Data___ getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(Data___ data) {
        this.data = data;
    }

}
