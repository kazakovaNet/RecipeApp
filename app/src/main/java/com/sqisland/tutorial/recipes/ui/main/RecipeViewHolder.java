package com.sqisland.tutorial.recipes.ui.main;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RecipeViewHolder extends RecyclerView.ViewHolder {
    public final TextView textView;
    
    public RecipeViewHolder(View itemView) {
        super(itemView);
        
        textView = (TextView) itemView;
    }
}
