package com.thoriq.mylist

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id:Int,
    @ColumnInfo("title")
    val title:String,
    @ColumnInfo("content")
    val content:String
) : Parcelable
