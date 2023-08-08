package com.example.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rvessayadapter extends RecyclerView.Adapter<rvessayadapter.viewHolder>{
    private final Context context;
    private final Database3 db;
    private static ArrayList<String> names, descriptions;

    public static class viewHolder extends RecyclerView.ViewHolder {
        Button button;
        private viewHolder(View view){
            super(view);
            this.button = view.findViewById(R.id.rvecButton);
        }
    }

    public rvessayadapter(Context context){
        this.context = context;
        this.db = new Database3(context);
        this.names = db.getAllNames();
        this.descriptions = db.getAllDescriptions();
    }

    @Override
    @NonNull
    public rvessayadapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new rvessayadapter.viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_recyclerview_ec, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull rvessayadapter.viewHolder holder, int position){
        Button button = holder.button;
        button.setText(names.get(position));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Delete?")
                        .setMessage("Description: " + descriptions.get(position))
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                db.delete(names.get(position));
                                Context context = v.getContext();
                                Intent intent = new Intent(context, EssayActivity.class);
                                context.startActivity(intent);
                                ((Activity)(context)).finish();
                            }
                        })
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .show();
            }
        });
    }

    @Override
    public int getItemCount(){
        return names.size();
    }
}
