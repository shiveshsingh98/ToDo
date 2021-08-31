package com.application.app8

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class ToDoAdapter(

    private val context: Context,
    private val listener: TodoCLickListener

): RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>(){


    var todos: ArrayList<Note>()



    inner class ToDoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var title:TextView = itemView.tvTitle
        var isChecked:CheckBox = itemView.cbDone
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        //val view=LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)


        //
        var view=ToDoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_todo,parent,false))
        //

        view.checkBox.setOnClickListener {
            val position = view.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClicked(todos[position])
            }
        }
        return view
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {

        holder.title.text = todos[position].text

//        holder.isChecked.setOnClickListener {
//            if(position != RecyclerView.NO_POSITION) {
//
//                notifyDataSetChanged()
//            }
//        }


        //
        var isChecked = false
        if(todos[position].checkBox == 1) isChecked = true
        holder.checkBox.isChecked = isChecked
        //

    }

    fun updateList(newList: List <Note>) {
        todos.clear()
        todos.addAll(newList)
        notifyDataSetChanged()
    }

}
interface TodoCLickListener {
    fun onItemClicked(note: Note)
}