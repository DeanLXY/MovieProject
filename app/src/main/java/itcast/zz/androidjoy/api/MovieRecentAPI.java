package itcast.zz.androidjoy.api;

import itcast.zz.androidjoy.model.MovieRecentBean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * ====================
 * 版权所有 违法必究
 *
 * @author wangx
 * @project AndroidJoy
 * @file ${FILE}
 * @create_time 2016/6/26
 * @github https://github.com/wangxujie
 * @blog http://wangxujie.github.io
 * ====================
 */
public interface MovieRecentAPI {
    public static final String BASEURL = "http://op.juhe.cn";
    public static final String KEY = "ee39f8ccbb136a0a91800922cf14b6d3";

    ///////////////////////////////////////////////////////////////////////////
    // 请求地址：http://op.juhe.cn/onebox/movie/pmovie
    // 请求参数：dtype=&city=%E9%83%91%E5%B7%9E&key=ee39f8ccbb136a0a91800922cf14b6d3
    // 请求方式：GET
    ///////////////////////////////////////////////////////////////////////////
    @GET("/onebox/movie/pmovie")
    public Observable<MovieRecentBean> getMovieRecent(@Query("city") String city,@Query("key") String key);
}
