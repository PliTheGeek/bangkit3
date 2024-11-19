package com.example.bangkit3.ui.finished

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bangkit3.network.Event
import com.example.bangkit3.repository.EventRepository

class FinishedViewModel : ViewModel() {

    private val repository = EventRepository()
    private val _events = MutableLiveData<List<Event>>(emptyList())
    val events: LiveData<List<Event>> get() = _events

    init {
        fetchEvents()
    }

    private fun fetchEvents() {
        repository.getEvents(0) { events ->
            _events.value = events ?: emptyList()
        }
    }
}