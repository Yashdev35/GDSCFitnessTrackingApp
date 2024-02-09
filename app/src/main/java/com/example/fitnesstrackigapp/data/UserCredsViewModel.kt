package com.example.fitnesstrackigapp.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.fitnesstrackigapp.Graph
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserCredsViewModel(
    private val repository: UserCredsRepository = Graph.userCredsRepository
): ViewModel() {

    var usernameState by mutableStateOf("")

    fun onUsernameChanged(newString: String){
        usernameState = newString
    }

    lateinit var getUserCredsHis : Flow<List<UserCreds>>

    init {
        viewModelScope.launch {
            getUserCredsHis = repository.getUserCredsHistory()
        }
    }

    fun addUserCreds(userCreds: UserCreds) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUserCreds(userCreds)
        }
    }
    fun updateUserCreds(userCreds: UserCreds) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUserCreds(userCreds)
        }
    }

    fun getUserCreds(id: Long): Flow<UserCreds> {
        return repository.getUserCreds(id)
    }

    fun deleteUserCreds(userCreds: UserCreds) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUserCreds(userCreds)
        }
    }
}

