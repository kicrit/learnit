package com.example.learnit.task

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.example.learnit.task.model.Task
import java.time.LocalTime
import java.time.ZoneId

class TaskAlarmScheduler(private val context: Context) {

    private val alarmManager = context.getSystemService(AlarmManager::class.java)

    fun schedule(task: Task) {
        // Jangan jadwalkan jika tidak ada tanggal atau waktu
        val dueDate = task.dueDate ?: return
        if (task.dueTime.isBlank()) return

        val intent = Intent(context, NotificationReceiver::class.java).apply {
            putExtra("TITLE", task.title)
            putExtra("MESSAGE", "Your task is due soon!")
            putExtra("NOTIFICATION_ID", task.id.hashCode())
        }

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            task.id.hashCode(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        try {
            val localDate = dueDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
            val localTime = LocalTime.parse(task.dueTime) // Misal: "14:30"

            val taskTime = localDate.atTime(localTime).atZone(ZoneId.systemDefault()).toEpochSecond() * 1000

            // Set alarm hanya jika waktunya di masa depan
            if (taskTime > System.currentTimeMillis()) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    if (alarmManager.canScheduleExactAlarms()) {
                        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, taskTime, pendingIntent)
                    }
                } else {
                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, taskTime, pendingIntent)
                }
            }
        } catch (e: Exception) {
            // Tangani error jika format waktu salah, dll.
            e.printStackTrace()
        }
    }

    fun cancel(task: Task) {
        val intent = Intent(context, NotificationReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            task.id.hashCode(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        alarmManager.cancel(pendingIntent)
    }
}
