package itcast.zz.androidjoy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import itcast.zz.androidjoy.R;
import itcast.zz.androidjoy.model.Datum_;
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
public class MovieRecentListAdapter extends RecyclerView.Adapter<MovieRecentListAdapter.RecentViewHolder> {
    private static final String TAG = MovieRecentListAdapter.class.getSimpleName();
    private Context context;
    private Result result;
    private int type;
    private OnRecyclerViewItemClickListener itemClickListener;

    public MovieRecentListAdapter(Context context, Result result, int type) {
        this.context = context;
        this.result = result;
        this.type = type;
    }

    public void setItemClickListener(OnRecyclerViewItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return result.getData().get(type).getData().size();
    }

    @Override
    public RecentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.item_movie_recent, null);
        return new RecentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecentViewHolder holder, final int position) {
        Datum_ datum_ = result.getData().get(type).getData().get(position);
        Glide.with(context)
                .load(datum_.getIconaddress())
                .into(holder.ivCover);

        holder.tvName.setText(datum_.getTvTitle());
//        holder.tvType.setText(datum_.getMore().);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(v, position);
                }
            }
        });
    }


    class RecentViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ivCover;
        private final TextView tvName;
        private final TextView tvType;

        public RecentViewHolder(View itemView) {
            super(itemView);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_movie_cover);
            tvName = (TextView) itemView.findViewById(R.id.tv_move_name);
            tvType = (TextView) itemView.findViewById(R.id.tv_movie_type);
        }
    }
}
