package com.example.calendo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calendo.R;

public class HorizontalAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private String[] list;
    private Context context;
    private OnItemClickListener listener;


    public HorizontalAdapter(Context c, String[] list, OnItemClickListener listener) {
        this.context = c;
        this.list = list;
        this.listener= listener;



    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.round_category, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        //Set the description
        holder.taskCategory.setText(list[position]);
        //Set the icon using a string stored in the DB

        //Category all
        if (position == 0 ){
            holder.buttonCategory.setImageResource(R.drawable.ic_all);
        } else {

            //Last element in the categories list
            if(position == list.length-1){
                holder.buttonCategory.setImageResource(R.drawable.ic_listadd);
            } else {
                //Retrieve the string from the DB and set the icon of the normal
                holder.buttonCategory.setImageResource(R.drawable.ic_book_black_24dp);
            }
        }




        holder.buttonCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),  "Position no: "+ position, Toast.LENGTH_LONG).show();
                listener.onItemClick(holder);


            }
        });

    }


    @Override
    public int getItemCount() {
        return list.length;
    }

    public interface OnItemClickListener {
        void onItemClick(RecyclerView.ViewHolder holder);

    }

}
