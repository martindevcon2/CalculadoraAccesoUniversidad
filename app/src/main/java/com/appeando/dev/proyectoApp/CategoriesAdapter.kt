package com.appeando.dev.proyectoApp

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.appeando.dev.R


interface OnCategoryClickListener {
    fun onCategoryClick(category: TaskCategory)
}
class CategoriesAdapter(
    private val categories:List<TaskCategory>,
    private val listener: OnCategoryClickListener) : RecyclerView.Adapter<CategoriesViewHolder>() {

    private var selectedPosition = -1





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val category = categories[position]
        holder.render (category)

        if (position == selectedPosition) {
            holder.itemView.foreground = ContextCompat.getDrawable(holder.itemView.context, R.drawable.card_highlight)
        } else {
            holder.itemView.foreground = null
        }

        holder.itemView.setOnClickListener {
            val currentPosition = holder.adapterPosition // Obtiene la posición actual
            if(selectedPosition == currentPosition) {
                selectedPosition = -1 // Deselecciona si ya está seleccionada
            } else {
                selectedPosition = currentPosition // Selecciona si no está seleccionada
            }
            notifyDataSetChanged() // Actualiza la vista del RecyclerView
            listener.onCategoryClick(category)
        }
    }
}