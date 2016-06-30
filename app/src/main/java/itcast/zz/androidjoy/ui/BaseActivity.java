package itcast.zz.androidjoy.ui;

import android.support.v7.app.AppCompatActivity;

import com.baidu.mobstat.StatService;

/**
 * Created by wangx on 2016/6/29.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        StatService.onResume(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        StatService.onPause(this);
    }
}
