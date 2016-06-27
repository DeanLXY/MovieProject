package itcast.zz.androidjoy.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import itcast.zz.androidjoy.R;

public class MovieLinkActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_link);
        setProgressBarVisibility(true);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("加载中..");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        webView = (WebView) findViewById(R.id.webview);

        webviewSetting(webView.getSettings());

        webView.loadUrl(getIntent().getStringExtra("url"));
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                getSupportActionBar().setTitle(title);
            }
        });
    }

    private void webviewSetting(WebSettings settings) {
        settings.setDefaultTextEncodingName("GBK");
        settings.setLightTouchEnabled(true);

        // requestFocus();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setAllowFileAccess(true);
        settings.setLoadWithOverviewMode(true);

        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);

        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);

        settings.setSupportZoom(true);
        // Technical settings
        settings.setSupportMultipleWindows(true);

        settings.setAppCacheEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);

        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        String dirapp = getDir("cache", Context.MODE_PRIVATE).getPath();
        settings.setAppCacheMaxSize(Long.MAX_VALUE);
        settings.setAppCachePath(dirapp);
        String dir = getDir("databases", Context.MODE_PRIVATE).getPath();
        settings.setDatabasePath(dir);
        dir = getDir("geolocation", Context.MODE_PRIVATE).getPath();
        settings.setGeolocationDatabasePath(dir);
    }
}
