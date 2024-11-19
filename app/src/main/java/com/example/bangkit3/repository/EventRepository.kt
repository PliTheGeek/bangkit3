package com.example.bangkit3.repository

import com.example.bangkit3.network.ApiClient
import com.example.bangkit3.network.ApiService
import com.example.bangkit3.network.Event
import com.example.bangkit3.network.EventDetail
import com.example.bangkit3.network.EventResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventRepository {
    private val apiService: ApiService = ApiClient.retrofit.create(ApiService::class.java)

    fun getEvents(active: Int, callback: (List<Event>?) -> Unit) {
        apiService.getEvents(active).enqueue(object : Callback<EventResponse> {
            override fun onResponse(call: Call<EventResponse>, response: Response<EventResponse>) {
                callback(response.body()?.listEvents)
            }

            override fun onFailure(call: Call<EventResponse>, t: Throwable) {
                callback(null)
            }
        })
    }

    fun getEventDetail(id: String, callback: (EventDetail?) -> Unit) {
        apiService.getEventDetail(id).enqueue(object : Callback<EventDetail> {
            override fun onResponse(call: Call<EventDetail>, response: Response<EventDetail>) {
                callback(response.body())
            }

            override fun onFailure(call: Call<EventDetail>, t: Throwable) {
                callback(null)
            }
        })
    }
}