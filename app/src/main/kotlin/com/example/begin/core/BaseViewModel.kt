package com.example.begin.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

typealias StateListener<S> = (S) -> Unit

abstract class BaseViewModel<E, S> : ViewModel() {

    abstract val initState: S

    private var stateListener: StateListener<S>? = null

    private var innerState: MutableLiveData<S> = MutableLiveData()

    fun onStateChange(lifecycleOwner: LifecycleOwner, callback: StateListener<S>) {
        innerState.observe(lifecycleOwner, callback)
        onSubscribe()
    }

    protected fun onSubscribe() {
        yield(initState)
    }

    protected fun yield(state: S) {
        if (state != innerState.value) {
            innerState.postValue(state!!)
        }
    }

    fun emit(event: E) {
        onNewEvent(event)
    }

    protected abstract fun onNewEvent(event: E)

    override fun onCleared() {
        super.onCleared()
        stateListener = null
    }
}