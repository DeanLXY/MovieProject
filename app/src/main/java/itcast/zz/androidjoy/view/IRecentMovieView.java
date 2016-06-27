package itcast.zz.androidjoy.view;

import itcast.zz.androidjoy.model.Result;

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
public interface IRecentMovieView {

    public void showProgress();
    public void hideProgress();

    public void showError();
    public void hideError();

    public void notifyDatas(Result result);
}
