package com.example.begin.presentation.adventures.list

import androidx.lifecycle.viewModelScope
import com.example.begin.core.BaseViewModel
import com.example.begin.data.db.dao.AdventuresDao
import com.example.begin.data.db.entities.Adventure
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AdventuresListViewModel(
    private val adventuresDao: AdventuresDao,
) : BaseViewModel<AdventuresListEvent, AdventuresListState>() {

    override val initState: AdventuresListState
        get() = AdventuresListState.Loading

    override fun onNewEvent(event: AdventuresListEvent) {
        if (event == AdventuresListEvent.Load) {
                yield(AdventuresListState.Loading)
                viewModelScope.launch(Dispatchers.IO) {
                    val adventures = adventuresDao.getAll()
                    if (adventures.isEmpty()) {
                        yield(AdventuresListState.Empty)
                    } else {
                        yield(AdventuresListState.Loaded(adventures))
                    }
                }
            }
        }
    }


sealed interface AdventuresListState {
    object Empty : AdventuresListState
    object Loading : AdventuresListState
    class Loaded(val adventures: List<Adventure>) : AdventuresListState
}

sealed interface AdventuresListEvent {
    object Load : AdventuresListEvent
}