package com.application.app8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var todoList= mutableListOf<ToDo>(
        ToDo("Follow me on Instagram", false),
        ToDo("Learn about recyclerView", false),
        ToDo("Feed my cat", false),
        ToDo("Prank my BOSS", false),
        ToDo("Eat some curry", false),
        ToDo("Ask my crush out", false),
        ToDo("Take a shower", false),
        ToDo("You can add an item now", false),
        ToDo("Also you can delete from the list", false),
        ToDo("But the app is still in progress", false),
        ToDo("Hopefully we would complete this", false),
        ToDo("that's why so much of dummy data", false)
    )
    val adapter=ToDoAdapter(todoList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rvToDos.adapter=adapter
        rvToDos.layoutManager=LinearLayoutManager(this)
        val deleteAlert=AlertDialog.Builder(this)
            .setTitle("Delete")
            .setMessage("Do you want to delete?")
            .setIcon(R.drawable.ic_delete)
            .setPositiveButton("Yes"){ _, _ ->
                deleteItem()
            }
            .setNegativeButton("No"){_, _ ->

            }.create()

        val addAlert=AlertDialog.Builder(this)
            .setTitle("Add")
            .setMessage("Do you want to add this todo?")
            .setIcon(R.drawable.ic_add)
            .setPositiveButton("Yes"){ _, _ ->
                if(etTodo.text.isEmpty())
                {
                    Toast.makeText(this,"Empty string can't be added!",Toast.LENGTH_LONG).show()
                }
                else{
                    val title=etTodo.text.toString()
                    val todo=ToDo(title,false)
                    todoList.add(todo)
                    etTodo.text=null
                    adapter.notifyItemInserted(todoList.size-1)
                    Log.d("insertItem","Insert a item")
                }
            }
            .setNegativeButton("No"){_, _ ->

            }.create()
        btnAddTodo.setOnClickListener {
            addAlert.show()

        }
        btnDeleteTodo.setOnClickListener {
            deleteAlert.show()
        }

    }

    private fun deleteItem() {
        while (true) {
            var letDelete = -1
            for (i in todoList.indices) {
                if (todoList[i].isChecked) {
                    letDelete = i
                    break
                }
            }
            if (letDelete == -1) {
                break
            } else {
                todoList.removeAt(letDelete)
                Log.d("shivesh", "$letDelete")
                adapter.notifyItemRemoved(letDelete)
            }
        }
    }
}