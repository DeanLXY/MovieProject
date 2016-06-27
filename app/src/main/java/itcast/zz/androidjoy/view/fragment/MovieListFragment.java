package itcast.zz.androidjoy.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import itcast.zz.androidjoy.R;
import itcast.zz.androidjoy.adapter.MovieRecentListAdapter;
import itcast.zz.androidjoy.model.Result;
import itcast.zz.androidjoy.presenter.MovieRecentPresenter;
import itcast.zz.androidjoy.view.IRecentMovieView;

public  class MovieListFragment extends Fragment implements IRecentMovieView, View.OnClickListener {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private RecyclerView recyclerView;
    private int type;
    private ProgressBar progressBar;
    private Button btnError;
    private MovieRecentPresenter presenter;

    public MovieListFragment() {
    }


    public static MovieListFragment newInstance(int sectionNumber) {
        MovieListFragment fragment = new MovieListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie, null);
        initView(rootView);
        presenter = new MovieRecentPresenter(this);
        presenter.getMovieRecent("");


        type = getArguments().getInt(ARG_SECTION_NUMBER, 0);

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
    public void notifyDatas(Result result) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(new MovieRecentListAdapter(getActivity(),result,type));
    }

    @Override
    public void onClick(View v) {
        presenter.getMovieRecent("");
    }
}
