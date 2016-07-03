package com.test.myrecycle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by hank on 2016/7/2.
 */
public class StaggeredHomeAdapter extends RecyclerView.Adapter<StaggeredHomeAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private List<String> mDatas;
    private List<Integer> mHeights;

    public StaggeredHomeAdapter(Context context, List<String> datas){
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
        mHeights = new ArrayList<Integer>();
        for(int i =0; i<mDatas.size(); i++){
            mHeights.add((int) (100+Math.random()*300));
        }
    }

    @Override
    public StaggeredHomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(mInflater.inflate(R.layout.item_home,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(StaggeredHomeAdapter.MyViewHolder holder, int position) {
        ViewGroup.LayoutParams lp = holder.tv.getLayoutParams();
        lp.height = mHeights.get(position);
        holder.tv.setLayoutParams(lp);
        holder.tv.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv;

        public MyViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.id_num);


        }
    }
}
