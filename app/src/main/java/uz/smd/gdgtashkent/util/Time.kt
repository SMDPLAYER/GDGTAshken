package uz.smd.gdgtashkent.util

import android.util.Log
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit

fun getDateDiff(format: SimpleDateFormat, oldDate: String?, newDate: String?): String {

    val secondsInMilli: Long = 1000
    val minutesInMilli: Long = secondsInMilli * 60
    val hoursInMilli = minutesInMilli * 60
    return try {

        var different = format.parse(newDate).time - format.parse(oldDate).time
        val elapsedHours = different / hoursInMilli
        different %= hoursInMilli

        val elapsedMinutes = different / minutesInMilli
        different %= minutesInMilli
        "$elapsedHours hours $elapsedMinutes minutes"
    } catch (e: Exception) {
        e.printStackTrace()
        "1"
    }

}

fun getDate(endTime: String, startTime: String): String {
    Log.e("MSM", endTime.substring(0, 2))
    Log.e("MSM", startTime.substring(0, 2))
    Log.e("MSM", endTime.substring(3, 5))
    Log.e("MSM", startTime.substring(3, 5))

    val hours = endTime.substring(0, 2).toInt() - startTime.substring(0, 2).toInt()
    val minutes = endTime.substring(3, 5).toInt() - startTime.substring(3, 5).toInt()
    return when {
        hours == 0 -> "$minutes mins"
        minutes == 0 -> "$hours hours"
        minutes < 0 ->"${60+minutes} mins"
        else -> "$hours hours $minutes mins"
    }

}
