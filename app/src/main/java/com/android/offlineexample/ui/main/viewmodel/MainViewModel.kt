package com.android.offlineexample.ui.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.offlineexample.data.model.User
import com.android.offlineexample.data.repository.MainRepository
import com.android.offlineexample.utils.Status
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val repository: MainRepository
) : ViewModel() {

    val _loading = MutableLiveData<Boolean>()
    private val _users = MutableLiveData<Status<List<User>>>()
    val users: LiveData<Status<List<User>>> get() = _users
    val _size = MutableLiveData<Int>()

    init {
        fetchUsers()
    }

    fun fetchUsers(refresh: Boolean = false) {
        viewModelScope.launch {
            try {
                _loading.value = true
                _users.postValue(Status.Loading)
                val users = repository.getUsers(refresh)
                _size.postValue(users.size)
                _users.postValue(Status.Success(users))
            }catch (e: Exception){
                _users.postValue(Status.Error(e))
            }finally {
                _loading.value = false
            }
        }
    }
}