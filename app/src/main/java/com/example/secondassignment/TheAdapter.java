package com.example.secondassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

public class TheAdapter extends RecyclerView.Adapter<TheAdapter.ViewHolder> {
    Context context;
    public ListData[] listData;

    public TheAdapter(Context context, ListData[] listData) {
        this.context = context;
        this.listData=listData;
    }

    @NonNull
    @NotNull
    @Override
    public TheAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TheAdapter.ViewHolder holder, int position) {
        holder.tvQuestion.setText(listData[position].getQuestion());
        holder.imgView.setImageResource(listData[position].getImgID());
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuestion;
        ImageView imgView;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvQuestion=itemView.findViewById(R.id.firstTextView);
            imgView=itemView.findViewById(R.id.firstImageView);

        }
    }
}
