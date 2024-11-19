// UpcomingFragment.kt
package com.example.bangkit3.ui.upcoming

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
import com.example.bangkit3.databinding.FragmentUpcomingBinding
import com.example.bangkit3.adapter.ItemAdapter

class UpcomingFragment : Fragment() {

    private var _binding: FragmentUpcomingBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UpcomingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpcomingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerViewUpcoming
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.events.observe(viewLifecycleOwner, Observer { events ->
            recyclerView.adapter = ItemAdapter(events) { event ->
                val bundle = Bundle().apply {
                    putString("eventId", event.id.toString())
                }
                findNavController().navigate(R.id.action_upcomingFragment_to_detailFragment, bundle)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}