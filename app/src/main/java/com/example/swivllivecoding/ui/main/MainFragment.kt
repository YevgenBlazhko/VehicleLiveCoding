package com.example.swivllivecoding.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.swivllivecoding.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }
    private lateinit var rvVehicles: RecyclerView
    private lateinit var rvAdapter: RvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        rvVehicles = view.findViewById(R.id.rv_vehicles)
        rvAdapter = RvAdapter()
        rvVehicles.adapter = rvAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
        viewModel.setList()
    }

    private fun setObserver() {
        viewModel.vehicles.observe(viewLifecycleOwner) {
            rvAdapter.updateRv(it)
        }
    }
}