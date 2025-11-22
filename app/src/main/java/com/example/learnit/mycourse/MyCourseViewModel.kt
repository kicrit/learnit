package com.example.learnit.course.mycourse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learnit.course.course.model.ListCourse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MyCourseViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    private val _myCourses = MutableLiveData<List<ListCourse>>()
    val myCourses: LiveData<List<ListCourse>> = _myCourses

    init {
        loadMyCourses()
    }

    fun loadMyCourses() {
        val uid = auth.currentUser?.uid ?: return

        db.collection("users")
            .document(uid)
            .collection("enrolledCourses")
            .addSnapshotListener { snapshot, _ ->

                val list = snapshot?.documents?.mapNotNull { doc ->
                    ListCourse(
                        id = doc.getLong("id")?.toInt() ?: return@mapNotNull null,
                        descCourse = doc.getString("title") ?: "",
                        descCourse2 = doc.getString("desc") ?: "",
                        progressCourse = doc.getString("progress") ?: "0%"
                    )
                } ?: emptyList()

                _myCourses.value = list
            }
    }


    // dipanggil saat user klik "Enroll Now"
    fun enrollCourse(course: ListCourse, onSuccess: () -> Unit, onFail: (String) -> Unit) {
        val uid = auth.currentUser?.uid ?: return onFail("User not logged in")

        val courseRef = db.collection("users")
            .document(uid)
            .collection("enrolledCourses")
            .document(course.id.toString())

        // Cek apakah sudah ada
        courseRef.get().addOnSuccessListener { doc ->
            if (doc.exists()) {
                onFail("Already enrolled")
                return@addOnSuccessListener
            }

            val data = mapOf(
                "id" to course.id,
                "title" to course.descCourse,
                "desc" to course.descCourse2,
                "progress" to course.progressCourse
            )

            courseRef.set(data)
                .addOnSuccessListener { onSuccess() }
                .addOnFailureListener { onFail("Failed to enroll") }
        }
    }
}
