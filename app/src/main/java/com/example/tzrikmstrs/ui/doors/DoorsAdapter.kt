package com.example.tzrikmstrs.ui.doors

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tzrikmstrs.R
import com.example.tzrikmstrs.model.door.Door

class DoorsAdapter : RecyclerView.Adapter<DoorsAdapter.DoorHolder>() {
    private var listDoors = emptyList<Door>()
    class DoorHolder(view: View): RecyclerView.ViewHolder(view){
        private val titleTextView: TextView = view.findViewById(R.id.titleDoor)
        private val imageDoor: ImageView = view.findViewById(R.id.imageDoor)
        fun bind(door: Door){
            titleTextView.text = door.name
            Glide.with(itemView)
                .load(door.snapshot)
                .into(imageDoor)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.camera_item,parent,false)
        return DoorHolder(view)
    }

    override fun getItemCount(): Int {
        return listDoors.size
    }

    override fun onBindViewHolder(holder: DoorHolder, position: Int) {
        val camera = listDoors[position]
        holder.bind(camera)
        holder.itemView.findViewById<Button>(R.id.btnFavorited)
        holder.itemView.findViewById<Button>(R.id.btnEdit)
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList(data: List<Door>){
        listDoors = data
        notifyDataSetChanged()
    }

}