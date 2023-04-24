package com.example.tzrikmstrs.ui.cameras

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.tzrikmstrs.R
import com.example.tzrikmstrs.SwipeCallback

class CamerasFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CamerasAdapter

    companion object {
        fun newInstance() = CamerasFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lateinit var swipeRefreshLayout: SwipeRefreshLayout
        val viewModel = ViewModelProvider(this)[CamerasViewVodel::class.java]
        val v = inflater.inflate(R.layout.fragment_cameras, container, false)
        recyclerView = v.findViewById(R.id.rv_cam)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = CamerasAdapter()
        recyclerView.adapter = adapter
        viewModel.loadCamList()

        viewModel.camerasList.observe(viewLifecycleOwner) { list ->
            adapter.setList(list)
        }
        val swipeToDeleteCallback = SwipeCallback()
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
        swipeRefreshLayout = v.findViewById(R.id.swipeRefreshLayout)
        swipeRefreshLayout.setOnRefreshListener {
        }
        return v
    }




}