package itcast.zz.androidjoy.presenter;

import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationListener;

import itcast.zz.androidjoy.model.LocationModel;
import itcast.zz.androidjoy.view.ILocationChangeView;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
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
public class LocationPresenter implements AMapLocationListener {

    private final LocationModel mode;
    public ILocationChangeView view;
    private Subscription subscribe;
    private Observable<AMapLocationClient> clientObservable;

    public LocationPresenter(ILocationChangeView view) {
        this.view = view;
        mode = new LocationModel();
    }


    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        view.showLocation(aMapLocation.getCity());
    }


    public void getLastLocation(Context context) {
        mode.getLocation(context)
                .observeOn(Schedulers.io())
                .map(new Func1<AMapLocationClient, AMapLocation>() {
                    @Override
                    public AMapLocation call(AMapLocationClient aMapLocationClient) {
                        return aMapLocationClient.getLastKnownLocation();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<AMapLocation>() {
                    @Override
                    public void call(AMapLocation aMapLocation) {
                        view.showLocation(aMapLocation.getCity());
                    }
                });
    }


    public void startLocation(Context context) {
        clientObservable = mode.getLocation(context)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        view.showLbsProgress();
                    }
                });

        clientObservable.subscribe(new Action1<AMapLocationClient>() {
            @Override
            public void call(AMapLocationClient aMapLocationClient) {
                aMapLocationClient.setLocationListener(LocationPresenter.this);
                aMapLocationClient.startLocation();
            }
        });

    }

    public void stopLocation() {
        clientObservable
                .subscribe(new Action1<AMapLocationClient>() {
                    @Override
                    public void call(AMapLocationClient aMapLocationClient) {
                        aMapLocationClient.stopLocation();
                    }
                });
    }
}
