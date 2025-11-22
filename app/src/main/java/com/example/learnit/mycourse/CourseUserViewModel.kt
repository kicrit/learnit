package com.example.learnit.mycourse

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

class CourseUserViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    fun enrollCourse(courseId: Int, onComplete: (Boolean) -> Unit) {
        val uid = auth.currentUser?.uid ?: return

        val userRef = db.collection("users").document(uid)

        userRef.update("enrolledCourses", FieldValue.arrayUnion(courseId))
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener { onComplete(false) }
    }

    fun getMyCourses(onResult: (List<Int>) -> Unit) {
        val uid = auth.currentUser?.uid ?: return

        db.collection("users").document(uid)
            .addSnapshotListener { snapshot, _ ->
                val list = snapshot?.get("enrolledCourses") as? List<Int> ?: emptyList()
                onResult(list)
            }
    }
}
