package com.example.begin.presentation.adventures.create

import androidx.lifecycle.viewModelScope
import com.example.begin.core.BaseViewModel
import com.example.begin.data.db.entities.Adventure
import com.example.begin.domain.usecases.CreateAdventureUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateAdventureViewModel(
    private val createAdventureUseCase: CreateAdventureUseCase,
) : BaseViewModel<CreateAdventureEvent, CreateAdventureState>() {

    override val initState: CreateAdventureState
        get() = CreateAdventureState.Idle

    override fun onNewEvent(event: CreateAdventureEvent) {
        when (event) {
            is CreateAdventureEvent.Create -> {
                yield(CreateAdventureState.Loading)
                viewModelScope.launch(Dispatchers.IO) {
                    createAdventureUseCase(
                        adventure = Adventure(
                            name = event.name,
                            description = event.description,
                        )
                    )
                    yield(CreateAdventureState.Created)
                }
            }
        }
    }
}

sealed interface CreateAdventureState {
    object Created : CreateAdventureState
    object Loading : CreateAdventureState
    object Idle : CreateAdventureState
}

sealed interface CreateAdventureEvent {
    class Create(val name: String, val description: String) : CreateAdventureEvent
}