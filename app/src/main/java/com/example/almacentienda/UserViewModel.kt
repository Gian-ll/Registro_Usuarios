package com.example.almacentienda

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    // LiveData para que la UI "escuche" el resultado
    val resultMessage = MutableLiveData<String>()

    fun onSaveUser(name: String) {
        viewModelScope.launch {
            val response = repository.processAndSave(name)
            resultMessage.value = response
        }
    }
}
