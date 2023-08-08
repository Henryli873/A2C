package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rvgradesadapter extends RecyclerView.Adapter<rvgradesadapter.viewHolder> {

    private final Context context;
    private final Database1 db;
    private final ArrayList<String> names;

    public static class viewHolder extends RecyclerView.ViewHolder {
        Button button;
        private viewHolder(View view){
            super(view);
            this.button = view.findViewById(R.id.rvecButton);
        }
    }

    public rvgradesadapter(Context context){
        this.context = context;
        this.db = new Database1(context);
        this.names = db.getAllNames();
    }

    @Override
    @NonNull
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_recyclerview_ec, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position){
        Button button = holder.button;
        button.setText(names.get(position));
    }

    @Override
    public int getItemCount(){
        return names.size();
    }
}
