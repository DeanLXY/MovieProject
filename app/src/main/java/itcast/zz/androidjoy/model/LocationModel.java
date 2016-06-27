package itcast.zz.androidjoy.model;

import android.content.Context;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * ====================
 * 版权所有 违法必究
 *
 * @author wangx
 * @project AndroidJoy
 * @file ${FILE}
 * @create_time 2016/6/27
 * @github https://github.com/wangxujie
 * @blog http://wangxujie.github.io
 * ====================
 */
public class LocationModel {
    public Observable<AMapLocationClient> getLocation(Context context) {

        return Observable.just(context)
                .subscribeOn(Schedulers.io())
                .map(new Func1<Context, Context>() {
                    @Override
                    public Context call(Context context) {
                        return context.getApplicationContext();
                    }
                })
                .flatMap(new Func1<Context, Observable<AMapLocationClient>>() {
                    @Override
                    public Observable<AMapLocationClient> call(Context context) {
                        AMapLocationClient locationClient = new AMapLocationClient(context.getApplicationContext());
                        AMapLocationClientOption locationOption = new AMapLocationClientOption();
                        // 设置定位模式为高精度模式
                        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
                        locationOption.setGpsFirst(true);
                        locationOption.setLocationCacheEnable(true);
                        locationOption.setInterval(1000*60*60*6);
                        locationClient.setLocationOption(locationOption);
                        return Observable.just(locationClient);
                    }
                });
    }
}
