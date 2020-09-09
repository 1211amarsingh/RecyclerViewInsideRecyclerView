package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.ParentViewHolder> {
    ArrayList<String> innerlist;
    LayoutInflater inflater;

    public InnerAdapter(Context context, ArrayList<String> innerlist) {
        this.innerlist = innerlist;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_child, null, false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, final int position) {
        holder.tvitem.setText(innerlist.get(position));
        holder.ibdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                innerlist.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return innerlist.size();
    }

    class ParentViewHolder extends RecyclerView.ViewHolder {
        TextView tvitem;
        ImageButton ibdelete;

        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvitem = itemView.findViewById(R.id.tvitem);
            ibdelete = itemView.findViewById(R.id.ibdelete);
        }
    }
}
