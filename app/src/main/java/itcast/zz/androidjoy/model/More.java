package itcast.zz.androidjoy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class More {

    @SerializedName("data")
    @Expose
    private List<Datum__> data = new ArrayList<Datum__>();
    @SerializedName("showname")
    @Expose
    private String showname;

    /**
     * @return The data
     */
    public List<Datum__> getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(List<Datum__> data) {
        this.data = data;
    }

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

}
