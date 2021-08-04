package com.application.app8

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class ToDoAdapter(
    var todos:List<ToDo>
): RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>(){
    inner class ToDoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var title = itemView.tvTitle
        var isChecked = itemView.cbDone
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
        return ToDoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {

        holder.title.text = todos[position].title
        holder.isChecked.isChecked = todos[position].isChecked

        holder.isChecked.setOnClickListener {
            if(position != RecyclerView.NO_POSITION) {
                todos[position].isChecked = !todos[position].isChecked
                notifyDataSetChanged()
            }
        }

//        holder.itemView.apply {
//            tvTitle.text=todos[position].title
//            cbDone.isChecked=todos[position].isChecked
//        }
//        holder.itemView.cbDone.setOnClickListener {
//            holder.itemView.cbDone.isChecked != holder.itemView.cbDone.isChecked
//            todos[position].isChecked != todos[position].isChecked
//        }

    }
}