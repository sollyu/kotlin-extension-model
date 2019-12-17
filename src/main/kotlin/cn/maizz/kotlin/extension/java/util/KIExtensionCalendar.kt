package cn.maizz.kotlin.extension.java.util

import java.util.*


fun Calendar.formTimestamp(timestamp: Long): Calendar {
    val calendar: Calendar = Calendar.getInstance()
    calendar.timeInMillis = timestamp
    return calendar
}

fun Calendar.fromDate(date: Date): Calendar = formTimestamp(date.time)

fun Calendar.getYear(): Int = get(Calendar.YEAR)
fun Calendar.getMonth(): Int = get(Calendar.MONTH)
fun Calendar.getDay(): Int = get(Calendar.DAY_OF_MONTH)
fun Calendar.getHour(): Int = get(Calendar.HOUR)
fun Calendar.getMinute(): Int = get(Calendar.MINUTE)
fun Calendar.getSecond(): Int = get(Calendar.SECOND)
fun Calendar.getMilliSecond(): Int = get(Calendar.MILLISECOND)

fun Calendar.toDate(): Date = Date(timeInMillis)
