package itcast.zz.androidjoy.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("1")
    @Expose
    private itcast.zz.androidjoy.model._1 _1;
    @SerializedName("m_1")
    @Expose
    private M1 m1;

    /**
     * @return The _1
     */
    public itcast.zz.androidjoy.model._1 get1() {
        return _1;
    }

    /**
     * @param _1 The 1
     */
    public void set1(itcast.zz.androidjoy.model._1 _1) {
        this._1 = _1;
    }

    /**
     * @return The m1
     */
    public M1 getM1() {
        return m1;
    }

    /**
     * @param m1 The m_1
     */
    public void setM1(M1 m1) {
        this.m1 = m1;
    }

}

