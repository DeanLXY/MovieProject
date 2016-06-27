package itcast.zz.androidjoy.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import itcast.zz.androidjoy.R;
import itcast.zz.androidjoy.adapter.MovieRecentListAdapter;
import itcast.zz.androidjoy.adapter.OnRecyclerViewItemClickListener;
import itcast.zz.androidjoy.model.Result;
import itcast.zz.androidjoy.presenter.MovieRecentPresenter;
import itcast.zz.androidjoy.ui.MovieLinkActivity;
import itcast.zz.androidjoy.view.IRecentMovieView;

public class MovieListFragment extends Fragment implements IRecentMovieView, View.OnClickListener {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_SECTION_CITY = "section_city";
    private static final String TAG = "movie";
    private RecyclerView recyclerView;
    private int type;
    private ProgressBar progressBar;
    private Button btnError;
    private MovieRecentPresenter presenter;
    private String city;

    public MovieListFragment() {
    }


    public static MovieListFragment newInstance(int sectionNumber, String city) {
        MovieListFragment fragment = new MovieListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putString(ARG_SECTION_CITY, city);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie, null);
        initView(rootView);
        type = getArguments().getInt(ARG_SECTION_NUMBER, 0);
        city = getArguments().getString(ARG_SECTION_CITY, "北京");
        presenter = new MovieRecentPresenter(this);
        Log.d(TAG, "onCreateView: " + city);
        if ("".equals(city)){
            city = "北京市";
        }
            presenter.getMovieRecent(city);


        return rootView;
    }

    private void initView(View rootView) {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress);

        btnError = (Button) rootView.findViewById(R.id.btn_error);
        btnError.setOnClickListener(this);

        btnError.setVisibility(View.GONE);

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        btnError.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideError() {
        btnError.setVisibility(View.GONE);
    }

    @Override
    public void notifyDatas(final Result result) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        MovieRecentListAdapter adapter = new MovieRecentListAdapter(getActivity(), result, type);
        recyclerView.setAdapter(adapter);
        adapter.setItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String link = result.getData().get(type).getData().get(position).getIconlinkUrl();
                Intent intent = new Intent(getActivity(), MovieLinkActivity.class);
                intent.putExtra("url", link);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onClick(View v) {
        presenter.getMovieRecent("");
    }
}
