package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ParentViewHolder> {
    ArrayList<Item> parentArrayList;
    LayoutInflater inflater;
    Context context;

    public ParentAdapter(Context context, ArrayList<Item> parentArrayList) {
        this.context = context;
        this.parentArrayList = parentArrayList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_parent, null, false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, final int position) {
        final Item item = parentArrayList.get(position);
        if (parentArrayList.size() > 1) {
            holder.ibdelete.setVisibility(View.VISIBLE);
        } else {
            holder.ibdelete.setVisibility(View.GONE);
        }
        holder.btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.innerArrayList.add((item.innerArrayList.size() + 1) + "");
                notifyDataSetChanged();
            }
        });

        holder.ibdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parentArrayList.remove(position);
                notifyDataSetChanged();
            }
        });

        InnerAdapter innerAdapter = new InnerAdapter(context, parentArrayList.get(position).innerArrayList);
        holder.recyclerview.setAdapter(innerAdapter);//        }
    }

    @Override
    public int getItemCount() {
        return parentArrayList.size();
    }

    class ParentViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerview;
        ImageButton ibdelete;
        Button btadd;

        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerview = itemView.findViewById(R.id.rvinner);
            btadd = itemView.findViewById(R.id.btadd);
            ibdelete = itemView.findViewById(R.id.ibdelete);
        }
    }
}
