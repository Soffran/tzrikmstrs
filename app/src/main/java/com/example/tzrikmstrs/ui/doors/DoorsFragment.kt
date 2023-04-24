package com.example.tzrikmstrs.ui.doors


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.tzrikmstrs.R
import com.example.tzrikmstrs.SwipeCallback

class DoorsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DoorsAdapter

    companion object;


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lateinit var swipeRefreshLayoutd: SwipeRefreshLayout
        val viewModel = ViewModelProvider(this)[DoorsViewModel::class.java]
        val v = inflater.inflate(R.layout.fragment_doors, container, false)
        recyclerView = v.findViewById(R.id.rv_door)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = DoorsAdapter()
        recyclerView.adapter = adapter
        viewModel.getDoorsList()
        viewModel.doorsList.observe(viewLifecycleOwner) { list ->
            adapter.setList(list)
        }
        val swipeToEditCallback = SwipeCallback()
        val itemTouchHelper = ItemTouchHelper(swipeToEditCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
        itemTouchHelper.attachToRecyclerView(recyclerView)
        swipeRefreshLayoutd = v.findViewById(R.id.swipeRefreshLayoutD)
        swipeRefreshLayoutd.setOnRefreshListener {
        }
        return v
    }



}