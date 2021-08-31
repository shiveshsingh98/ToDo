package com.application.app8

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class Note(@ColumnInfo(name = "text")var text:String,@ColumnInfo(name = "checkBox") var checkBox: Int) {
    @PrimaryKey(autoGenerate = true)var id = 0
}