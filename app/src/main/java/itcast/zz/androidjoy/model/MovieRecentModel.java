package itcast.zz.androidjoy.model;

import android.support.annotation.NonNull;

import itcast.zz.androidjoy.api.MovieRecentAPI;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
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
public class MovieRecentModel {
    // 处理  业务逻辑
    public Observable<MovieRecentBean> getMovieRecent(@NonNull String city) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MovieRecentAPI.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        MovieRecentAPI movieRecentAPI = retrofit.create(MovieRecentAPI.class);
        return movieRecentAPI.getMovieRecent("郑州", MovieRecentAPI.KEY);
    }
}
