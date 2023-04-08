package com.example.viikko11;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    TextView notes;
    ImageView editImage, removeImage;
    EditText editNotes;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        notes = itemView.findViewById(R.id.textNotes);
        editImage = itemView.findViewById(R.id.imgEdit);
        removeImage = itemView.findViewById(R.id.imgRemove);
        editNotes = itemView.findViewById(R.id.editNotes);
    }
}
