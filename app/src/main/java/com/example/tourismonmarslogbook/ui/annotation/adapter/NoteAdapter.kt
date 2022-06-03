package com.example.tourismonmarslogbook.ui.annotation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tourismonmarslogbook.database.Note
import com.example.tourismonmarslogbook.databinding.ListItemBinding

class NoteAdapter : ListAdapter<Note, NoteAdapter.NoteViewHolder>(NoteDiffUtil) {

    object NoteDiffUtil : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.noteId == newItem.noteId
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val user = getItem(position)
        holder.bindCell(user)
    }

    class NoteViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindCell(note: Note) {

            binding.txtTitle.text = note.title
            binding.txtDecription.text = note.description
        }
    }
}