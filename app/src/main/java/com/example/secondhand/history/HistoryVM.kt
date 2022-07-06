package com.example.secondhand.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.secondhand.entity.History
import com.example.secondhand.repository.ProductRepo


class HistoryVM : ViewModel() {
    private val state = MutableLiveData<HistoryState>()
    private val history = MutableLiveData<List<History>>()
    private val repo = ProductRepo()

    private fun loading(b: Boolean) {
        state.value = HistoryState.Loading(b)
    }

    fun getHistory(accestoken: String?) {
        loading(true)
        repo.getHistory(accestoken) { sproduct, error ->
            loading(false)
            error?.let { it.message?.let { message -> println(message) } }
            sproduct?.let { history.postValue(it) }
        }
    }
    fun getState() =state
    fun getHistory() = history
}

sealed class HistoryState{
    data class Loading(val isLoading: Boolean) : HistoryState()
}