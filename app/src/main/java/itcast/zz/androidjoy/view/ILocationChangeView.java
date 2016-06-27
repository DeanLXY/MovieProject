package itcast.zz.androidjoy.view;

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
public interface ILocationChangeView {
    public void showLbsProgress();
    public void hideLbsProgress();

    public void startLocation();
    public void stopLocation();

    public void showLocation(String city);
}
