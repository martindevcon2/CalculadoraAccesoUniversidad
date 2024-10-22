package com.appeando.dev.proyectoApp

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.appeando.dev.R


class CategoriesViewHolder(view:View) : RecyclerView.ViewHolder(view){

    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategory)
    private val divider: View = view.findViewById(R.id.viewCategory)

    fun render (taskCategory: TaskCategory) {


        when (taskCategory) {
            TaskCategory.Derecho -> {
                tvCategoryName.text = "Derecho"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.proyecto_derecho_category)
                )
            }

            TaskCategory.Economía -> {
                tvCategoryName.text = "Economía"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.proyecto_economía_category)
                )
            }

            TaskCategory.Ingeniería -> {
                tvCategoryName.text = "Ingeniería"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.proyecto_ingeniería_category)
                )
            }

            TaskCategory.Magisterio -> {
                tvCategoryName.text = "Magisterio"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.proyecto_magisterio_category)
                )
            }

            TaskCategory.Medicina -> {
                tvCategoryName.text = "Medicina"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.proyecto_medicina_category)
                )
            }

            TaskCategory.Periodismo -> {
                tvCategoryName.text = "Periodismo"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.proyecto_periodismo_category)
                )
            }

            TaskCategory.Turismo -> {
                tvCategoryName.text = "Turismo"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.proyecto_turismo_category)
                )
            }
        }
        divider.visibility = View.VISIBLE
    }
}