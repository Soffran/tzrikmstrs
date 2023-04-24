package com.example.tzrikmstrs.ui.cameras

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
import com.example.tzrikmstrs.model.camera.Camera


class CamerasAdapter:RecyclerView.Adapter<CamerasAdapter.CameraHolder>() {
    private var listCamera = emptyList<Camera>()
    class CameraHolder(view: View):RecyclerView.ViewHolder(view){
        private val titleTextView: TextView = view.findViewById(R.id.titleCam)
        private val imageCam: ImageView = view.findViewById(R.id.imageCam)
        fun bind(camera: Camera) {
            titleTextView.text = camera.name
            Glide.with(itemView)
                .load(camera.snapshot)
                .into(imageCam)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.camera_item,parent,false)
        return CameraHolder(view)
    }

    override fun getItemCount(): Int {
        return listCamera.size
    }

    override fun onBindViewHolder(holder: CameraHolder, position: Int) {
        val camera = listCamera[position]
        holder.bind(camera)
        holder.itemView.findViewById<Button>(R.id.btnFavorite)
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList(data: List<Camera>){
        listCamera = data
        notifyDataSetChanged()
    }
}