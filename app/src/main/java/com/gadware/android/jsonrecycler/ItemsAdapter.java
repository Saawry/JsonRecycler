package com.gadware.android.jsonrecycler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gadware.android.jsonrecycler.databinding.ItemsCardBinding;

import java.util.List;


public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private final Context context;
    private final List<DataPojo> itemsList;


    public ItemsAdapter(Context context, List<DataPojo> itemsList) {
        this.context = context;
        this.itemsList = itemsList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemsCardBinding binding = ItemsCardBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final DataPojo model = itemsList.get(position);


        holder.binding.tvTitle.setText(model.getTitle());
        holder.binding.tvDesc.setText(model.getDescription());


        holder.binding.tvTitle.setOnClickListener(v -> {
            Intent intent=new Intent(context,DetailsActivity.class);
            intent.putExtra("title",model.getTitle());
            intent.putExtra("desc",model.getDescription());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemsCardBinding binding;

        public ViewHolder(@NonNull ItemsCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
