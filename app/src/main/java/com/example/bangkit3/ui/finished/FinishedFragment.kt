// FinishedFragment.kt
package com.example.bangkit3.ui.finished

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bangkit3.R
import com.example.bangkit3.databinding.FragmentFinishedBinding
import com.example.bangkit3.adapter.ItemAdapter

class FinishedFragment : Fragment() {

    private var _binding: FragmentFinishedBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FinishedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerViewFinished
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.events.observe(viewLifecycleOwner, Observer { events ->
            recyclerView.adapter = ItemAdapter(events) { event ->
                val bundle = Bundle().apply {
                    putString("eventId", event.id.toString())
                }
                findNavController().navigate(R.id.action_finishedFragment_to_detailFragment, bundle)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}