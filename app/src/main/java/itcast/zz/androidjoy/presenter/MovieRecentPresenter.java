package itcast.zz.androidjoy.presenter;

import android.util.Log;

import itcast.zz.androidjoy.api.MovieRecentAPI;
import itcast.zz.androidjoy.model.MovieRecentBean;
import itcast.zz.androidjoy.model.MovieRecentModel;
import itcast.zz.androidjoy.model.Result;
import itcast.zz.androidjoy.view.IRecentMovieView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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
public class MovieRecentPresenter {

    private static final String TAG = MovieRecentPresenter.class.getSimpleName();
    private final MovieRecentModel model;
    private IRecentMovieView view;

    public MovieRecentPresenter(IRecentMovieView view) {
        this.view = view;
        model = new MovieRecentModel();
    }

    public void getMovieRecent(String city) {
        model.getMovieRecent(city)
                .subscribeOn(Schedulers.io())
                .map(new Func1<MovieRecentBean, Result>() {
                    @Override
                    public Result call(MovieRecentBean movieRecentBean) {

                        return movieRecentBean.getResult();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        view.showProgress();
                    }
                })
                .subscribe(new Subscriber<Result>() {
                    @Override
                    public void onCompleted() {
                        view.hideProgress();
                        view.hideError();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError();
                        view.hideProgress();
                    }

                    @Override
                    public void onNext(Result result) {
 view.notifyDatas(result);
                    }
                });
    }

}
