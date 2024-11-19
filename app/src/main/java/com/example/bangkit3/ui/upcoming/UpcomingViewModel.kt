package com.example.bangkit3.ui.upcoming

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bangkit3.network.Event
import com.example.bangkit3.repository.EventRepository

class UpcomingViewModel : ViewModel() {

    private val repository = EventRepository()
    private val _events = MutableLiveData<List<Event>>(emptyList())
    val events: LiveData<List<Event>> get() = _events

    init {
        fetchEvents()
    }

    private fun fetchEvents() {
        repository.getEvents(1) { events ->
            _events.value = events ?: emptyList()
        }
    }
}