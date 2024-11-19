
package com.example.bangkit3.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bangkit3.network.EventDetail
import com.example.bangkit3.repository.EventRepository

class DetailViewModel : ViewModel() {

    private val repository = EventRepository()
    private val _eventDetail = MutableLiveData<EventDetail>()
    val eventDetail: LiveData<EventDetail> get() = _eventDetail

    fun setEventId(eventId: String) {
        repository.getEventDetail(eventId) { eventDetail ->
            _eventDetail.value = eventDetail
        }
    }
}