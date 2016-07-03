package com.test.myrecycle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hank on 2016/7/3.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder>{

    private  List<Integer> mDatas;
    private  LayoutInflater mInflater;


    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mOnItemClicklistener;

    public void setmOnItemClicklistener(OnItemClickListener mOnItemClicklistener){
        this.mOnItemClicklistener = mOnItemClicklistener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
        ImageView mImg;
        TextView mTxt;
    }

    public GalleryAdapter(Context context, List<Integer> datas){
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
    }


    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_home,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.mImg = (ImageView) view.findViewById(R.id.id_index_gallery_item_image);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final GalleryAdapter.ViewHolder holder, final int position) {
        holder.mImg.setImageResource(mDatas.get(position));

        if(mOnItemClicklistener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClicklistener.onItemClick(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
