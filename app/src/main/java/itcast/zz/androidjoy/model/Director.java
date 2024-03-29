package itcast.zz.androidjoy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Director {

    @SerializedName("showname")
    @Expose
    private String showname;
    @SerializedName("data")
    @Expose
    private Data data;

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
    public Data getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(Data data) {
        this.data = data;
    }

}
