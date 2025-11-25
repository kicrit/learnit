package com.example.learnit.task

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.learnit.R

class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val title = intent.getStringExtra("TITLE") ?: "Task Reminder"
        val message = intent.getStringExtra("MESSAGE") ?: "You have a task due soon."
        val notificationId = intent.getIntExtra("NOTIFICATION_ID", 0)

        // Intent untuk membuka activity full-screen jika diinginkan
        val fullScreenIntent = Intent(context, FullScreenNotificationActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("TITLE", title)
            putExtra("MESSAGE", message)
        }

        val fullScreenPendingIntent = PendingIntent.getActivity(
            context,
            notificationId,
            fullScreenIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(context, "TASK_REMINDER_CHANNEL")
            .setSmallIcon(R.drawable.ic_launcher_foreground) // Ganti dengan ikon notifikasi Anda
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH) // <-- INI KUNCINYA UNTUK POP-UP
            .setCategory(NotificationCompat.CATEGORY_ALARM) 
            .setFullScreenIntent(fullScreenPendingIntent, true) // Opsional: untuk notifikasi layar penuh
            .build()

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(notificationId, notification)
    }
}
