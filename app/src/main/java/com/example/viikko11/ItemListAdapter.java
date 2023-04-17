package com.example.viikko11;

import android.content.Context;
import android.opengl.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private ArrayList<Item> items = new ArrayList<>();

    public ItemListAdapter(ArrayList<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_view, viewGroup, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, final int position) {
        holder.notes.setText(items.get(position).getNotes());

        holder.removeImage.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            Storage.getInstance().removeItem(items.get(pos).getId());
            notifyItemRemoved(pos);
        });

        holder.editImage.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            if (holder.editNotes.getVisibility() == View.VISIBLE) {
                Item item = Storage.getInstance().getItem(pos);
                item.setNotes(holder.editNotes.getText().toString());
                holder.editNotes.setVisibility(View.GONE);
                notifyItemChanged(pos);
            } else {
                holder.editNotes.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
