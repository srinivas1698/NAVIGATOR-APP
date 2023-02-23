package edu.sjsu.android.project3srinivasraochavan;

import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.view.LayoutInflater;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.sjsu.android.project3srinivasraochavan.databinding.FragmentRowBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final ArrayList<Item> data;
    private final ListFragment obj;
    // todo :pass in the onClick method in the ListFragment.java
    //hint: you will change the constructor , the onCreateViewHolder
    // and the ViewHolder class
    public MyAdapter(ArrayList<Item> data,ListFragment obj) {
        this.obj=obj;
        this.data = data;
    }
    //*
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //todo
        return new ViewHolder(FragmentRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false),obj);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Item item=data.get(position);
        holder.binding.icon.setImageResource(item.getImageID());
        holder.binding.name.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final FragmentRowBinding binding;

        public ViewHolder(FragmentRowBinding binding, ListFragment obj) {
            super(binding.getRoot());
            this.binding=binding;
            binding.getRoot().setOnClickListener(view->{
                int position = getLayoutPosition();
                MyAdapter.this.obj.onClick(position);
                }
                //todo: set OnclickListener
                //Hint: pass in the onClick method in the ListFragment.java
                //get the position using getLayoutPosition() method to get the position of the current
                // row(that's being selected
            );
        }
    }
}