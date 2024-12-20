// DetailFragment.kt
package com.example.bangkit3.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.bangkit3.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve the eventId from the arguments
        val eventId = arguments?.getString("eventId") ?: return

        // Use the eventId to fetch and display the relevant data
        viewModel.setEventId(eventId)
        viewModel.eventDetail.observe(viewLifecycleOwner) { eventDetail ->
            binding.textViewTitle.text = eventDetail?.name
            binding.textViewDescription.text = eventDetail?.description
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}