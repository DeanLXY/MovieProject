package itcast.zz.androidjoy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayDate {

    @SerializedName("showname")
    @Expose
    private String showname;
    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("data2")
    @Expose
    private String data2;

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
    public String getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return The data2
     */
    public String getData2() {
        return data2;
    }

    /**
     * @param data2 The data2
     */
    public void setData2(String data2) {
        this.data2 = data2;
    }

}
