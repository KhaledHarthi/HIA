package com.khaledharthi.harajinterviewapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.khaledharthi.harajinterviewapp.ContentDisplayActivity;
import com.khaledharthi.harajinterviewapp.Models.PostItem;
import com.khaledharthi.harajinterviewapp.R;

import java.util.ArrayList;

public class MainPostAdapter extends RecyclerView.Adapter<MainPostAdapter.ViewHolder>{

    private ArrayList<PostItem> list = new ArrayList<>();
    private RecyclerView rv;
    private Context context;


    public MainPostAdapter(Context context, RecyclerView recyclerView){
        this.context = context;
        rv = recyclerView;
    }


    /**
     * Sets data of adapter (Be cautious will erase any previous entries)
     * @param list List of PostItems to be displayed
     */
    public void setData(@NonNull ArrayList<PostItem> list){
        this.list = list;
        notifyDataSetChanged();
    }


    /**
     * Adds a batch of data to adapter
     * @param batch Items to be inserted
     */
    public void addCollection (@NonNull ArrayList<PostItem> batch){
        list.addAll(batch);
        int start = (list.size()-1) - batch.size();
        int end = (list.size()-1);
        notifyItemRangeInserted(start, end);
    }


    /**
     * Inserts item into adapter
     * @param item Item to be inserted
     */
    public void addItem(@NonNull PostItem item){
        list.add(item);
        notifyItemInserted(list.size()-1);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        v.setOnClickListener(clickListener);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostItem item = list.get(position);

        holder.titleTV.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    // Item click listener
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int itemPosition = rv.getChildAdapterPosition(view);
            PostItem item = list.get(itemPosition);

            Intent intent = new Intent(context, ContentDisplayActivity.class);
            intent.putExtra("name", item.getName());
            intent.putExtra("imgURL", item.getImgURL());
            context.startActivity(intent);
        }
    };

    // ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder{

        TextView titleTV;
        public ViewHolder(View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
        }
    }
}

