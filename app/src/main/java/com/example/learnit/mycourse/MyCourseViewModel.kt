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

    private val _videoCompletion = MutableLiveData<Map<Int, Boolean>>()
    val videoCompletion: LiveData<Map<Int, Boolean>> = _videoCompletion

    init {
        loadMyCourses()
        loadVideoCompletionState(1) // Assuming courseId 1 for Web Programming
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
                        progressCourse = doc.getString("progress") ?: "0%",
                        category = doc.getString("category") ?: ""
                    )
                } ?: emptyList()

                _myCourses.value = list
            }
    }

    fun enrollCourse(course: ListCourse, onSuccess: () -> Unit, onFail: (String) -> Unit) {
        val uid = auth.currentUser?.uid ?: return onFail("User not logged in")

        val courseRef = db.collection("users")
            .document(uid)
            .collection("enrolledCourses")
            .document(course.id.toString())

        courseRef.get().addOnSuccessListener { doc ->
            if (doc.exists()) {
                onFail("Already enrolled")
                return@addOnSuccessListener
            }

            val data = mapOf(
                "id" to course.id,
                "title" to course.descCourse,
                "desc" to course.descCourse2,
                "progress" to course.progressCourse,
                "category" to course.category,
                "completed_videos" to emptyList<Int>()
            )

            courseRef.set(data)
                .addOnSuccessListener { onSuccess() }
                .addOnFailureListener { onFail("Failed to enroll") }
        }
    }

    fun toggleVideoCompletion(courseId: Int, videoId: Int) {
        val uid = auth.currentUser?.uid ?: return
        val courseRef = db.collection("users").document(uid).collection("enrolledCourses").document(courseId.toString())

        db.runTransaction {
            val snapshot = it.get(courseRef)
            val completedVideos = snapshot.get("completed_videos") as? List<Long> ?: emptyList()
            val isCompleted = completedVideos.contains(videoId.toLong())

            val newCompletedVideos = if (isCompleted) {
                completedVideos.filter { it.toInt() != videoId }
            } else {
                completedVideos + videoId.toLong()
            }

            it.update(courseRef, "completed_videos", newCompletedVideos)

            // Update progress
            val totalVideos = 5 // Hardcoded for now, you might want to make this dynamic
            val progress = (newCompletedVideos.size.toFloat() / totalVideos.toFloat() * 100).toInt()
            it.update(courseRef, "progress", "$progress%")
        }.addOnSuccessListener {
            loadVideoCompletionState(courseId)
        }
    }

    private fun loadVideoCompletionState(courseId: Int) {
        val uid = auth.currentUser?.uid ?: return
        db.collection("users").document(uid).collection("enrolledCourses").document(courseId.toString())
            .get().addOnSuccessListener { snapshot ->
                val completedVideos = snapshot.get("completed_videos") as? List<Long> ?: emptyList()
                val completionMap = completedVideos.map { it.toInt() to true }.toMap()
                _videoCompletion.value = completionMap
            }
    }
}
