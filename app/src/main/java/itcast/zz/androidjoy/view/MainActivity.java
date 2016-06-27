package itcast.zz.androidjoy.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import itcast.zz.androidjoy.R;
import itcast.zz.androidjoy.adapter.MovieRecentListAdapter;
import itcast.zz.androidjoy.model.Result;
import itcast.zz.androidjoy.presenter.MovieRecentPresenter;

public class MainActivity extends AppCompatActivity implements IRecentMovieView {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MovieRecentPresenter presenter = new MovieRecentPresenter(this);
        presenter.getMovieRecent("");

        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void hideError() {

    }

    @Override
    public void notifyDatas(Result result) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(new MovieRecentListAdapter(this,result, 0));
    }
}
