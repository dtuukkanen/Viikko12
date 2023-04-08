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
    private Context context;
    private ArrayList<Item> items = new ArrayList<>();

    public ItemListAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
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
                notifyDataSetChanged();
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
