package itcast.zz.androidjoy.ui;

import android.Manifest;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import itcast.zz.androidjoy.R;
import itcast.zz.androidjoy.presenter.LocationPresenter;
import itcast.zz.androidjoy.ui.fragment.MovieListFragment;
import itcast.zz.androidjoy.utils.AfterPermissionGranted;
import itcast.zz.androidjoy.utils.EasyPermissions;
import itcast.zz.androidjoy.view.ILocationChangeView;

public class MovieActivity extends AppCompatActivity implements ILocationChangeView, EasyPermissions.PermissionCallbacks {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private LocationPresenter presenter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mViewPager = (ViewPager) findViewById(R.id.container);

        tabLayout = (TabLayout) findViewById(R.id.tabs);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        presenter = new LocationPresenter(this);

//        locationTask();

//        presenter.getLastLocation(this);
        startLocation();
    }

    @AfterPermissionGranted(100)
    private void locationTask() {
        if (EasyPermissions.hasPermissions(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Have permission, do the thing!
//            presenter.getLastLocation(this);
            startLocation();
        } else {
            // Ask for one permission
            // this Activity  window token  == null
            EasyPermissions.requestPermissions(this, "定位权限",
                    100, Manifest.permission.ACCESS_FINE_LOCATION);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopLocation();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_movie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showLbsProgress() {
        getSupportActionBar().setIcon(R.drawable.ic_room_black_24dp);
        getSupportActionBar().setTitle("定位中...");
    }

    @Override
    public void hideLbsProgress() {

    }

    @Override
    public void startLocation() {
        presenter.startLocation(this);
    }

    @Override
    public void stopLocation() {
        presenter.stopLocation();
    }

    @Override
    public void showLocation(String city) {
        getSupportActionBar().setTitle(city);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), city);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private String city;

        public SectionsPagerAdapter(FragmentManager fm, String city) {
            super(fm);
            this.city = city;
        }

        @Override
        public Fragment getItem(int position) {
            return MovieListFragment.newInstance(position, city);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "今日上映";
                case 1:
                    return "即将上映";

            }
            return null;
        }
    }
}
