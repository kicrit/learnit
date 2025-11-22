package com.example.learnit.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class AuthViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _authState = MutableLiveData<AuthState>()
    private val _userData = MutableLiveData<Map<String, Any>?>()
    private val _updateState = MutableLiveData<UpdateState>()

    val userData: LiveData<Map<String, Any>?> = _userData
    val authState: LiveData<AuthState> = _authState
    val updateState: LiveData<UpdateState> = _updateState


    init {
        checkAuthStatus()
    }

    fun loadUserData() {
        val uid = auth.currentUser?.uid ?: return

        db.collection("users")
            .document(uid)
            .get()
            .addOnSuccessListener { doc ->
                _userData.value = doc.data
            }
    }

    fun updateUsername(newUsername: String) {
        val uid = auth.currentUser?.uid ?: run {
            _updateState.value = UpdateState.Error("User not logged in")
            return
        }

        if (newUsername.isBlank()) {
            _updateState.value = UpdateState.Error("Username cannot be empty")
            return
        }

        _updateState.value = UpdateState.Loading

        db.collection("users")
            .document(uid)
            .update("username", newUsername)
            .addOnSuccessListener {
                _updateState.value = UpdateState.Success
                // also refresh user data
                loadUserData()
            }
            .addOnFailureListener { e ->
                _updateState.value = UpdateState.Error(e.message ?: "Failed to update username")
            }
    }

    fun resetUpdateState() {
        _updateState.value = UpdateState.Idle
    }

    fun checkAuthStatus() {
        if (auth.currentUser == null) {
            _authState.value = AuthState.Unauthenticated
        } else {
            _authState.value = AuthState.Authenticated
        }
    }

    fun login(email: String, password: String) {

        if (email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Error("Email or password can't be empty")
            return
        }

        _authState.value = AuthState.Loading
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _authState.value = AuthState.Authenticated
                } else {
                    _authState.value =
                        AuthState.Error(task.exception?.message ?: "Something went wrong")
                }
            }
    }

    fun signup(email: String, password: String, username: String) {

        if (email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Error("Email or password can't be empty")
            return
        }

        _authState.value = AuthState.Loading

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val userId = auth.currentUser?.uid ?: return@addOnCompleteListener
                    val userData = hashMapOf(
                        "username" to username,
                        "email" to email,
                        "createdAt" to System.currentTimeMillis(),
                        "enrolledCourses" to emptyList<Int>()
                    )


                    db.collection("users")
                        .document(userId)
                        .set(userData)
                        .addOnSuccessListener {
                            _authState.value = AuthState.Authenticated
                        }
                        .addOnFailureListener {
                            _authState.value =
                                AuthState.Error("Signup success but failed saving data")
                        }
                } else {
                    _authState.value =
                        AuthState.Error(task.exception?.message ?: "Something went wrong")
                }
            }
    }


    fun signout() {
        auth.signOut()
        _authState.value = AuthState.Unauthenticated
    }

    fun getUserData() {
        val uid = auth.currentUser?.uid ?: return

        db.collection("users")
            .document(uid)
            .get()
            .addOnSuccessListener { doc ->
                val username = doc.getString("username")
                // lakukan sesuatu dengan username
            }
    }

}

sealed class AuthState {
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
    object Loading : AuthState()
    data class Error(val message: String) : AuthState()
}

sealed class UpdateState {
    object Idle : UpdateState()
    object Loading : UpdateState()
    object Success : UpdateState()
    data class Error(val message: String) : UpdateState()
}