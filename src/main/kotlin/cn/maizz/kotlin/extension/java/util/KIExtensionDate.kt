/*
 * Copyright 2018 Sollyu, Wonium
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.maizz.kotlin.extension.java.util

import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*

/**
 * 对java.util.Date类进行增强
 */

/**
 * 格式化日期
 */
fun Date.format(format: String = "yyyy-MM-dd HH:mm:ss", locale: Locale = Locale.getDefault()) =
    SimpleDateFormat(format, locale).format(this)

/**
 * 是否是今天
 *
 * @param todayDate 今天的日期 默认为当日
 */
@Suppress(names = ["DEPRECATION"])
fun Date.isToday(todayDate: Date = Date()): Boolean =
    this.year == todayDate.year && this.month == todayDate.month && this.dayMonth() == todayDate.dayMonth()

/**
 * 是否是一个未来的时间
 *
 * @param targetDate 目标日期
 */
fun Date.isFuture(targetDate: Date = Date()): Boolean = this.time > targetDate.time

/**
 * 当前日期是否为明天
 */
fun Date.isTomorrow(): Boolean {
    val todayCalendar: Calendar = Calendar.getInstance().apply { this.add(Calendar.DAY_OF_MONTH, 1) }
    val tomorrowCalendar: Calendar = Calendar.getInstance().apply { this.timeInMillis = this@isTomorrow.time }
    return (todayCalendar.get(Calendar.YEAR) == tomorrowCalendar.get(Calendar.YEAR) && todayCalendar.get(Calendar.MONTH) == tomorrowCalendar.get(Calendar.MONTH) && todayCalendar.get(Calendar.DAY_OF_MONTH) == tomorrowCalendar.get(Calendar.DAY_OF_MONTH))
}

/**
 * 使一个日期相加
 * @param field  单位，默认天
 * @param amount 数量，默认1, 也可为负数
 */
fun Date.add(field: Int = Calendar.DAY_OF_MONTH, amount: Int = 1): Date =
    Calendar.getInstance().apply { this.timeInMillis = this@add.time; this.add(field, amount) }.time

/**
 * 两个日期相减
 * @param date 另外一个日期
 */
fun Date.sub(date: Date): Date = Date(this.time - date.time)

/**
 * 转换成Calendar对象
 */
fun Date.toCalendar(): Calendar = Calendar.getInstance().also { it.timeInMillis = this.time }

/**
 * 获取本月的第几天
 */
fun Date.dayMonth(): Int = this.toCalendar().get(Calendar.DAY_OF_MONTH)

/**
 * 获取今日，2019/1/3 14:05:00 => 2019/1/3 00:00:00
 */
fun Date.day(): Date = Date(this.year, this.month, this.dayMonth())

/**
 * 将日期转换成日期单位
 *
 * 注意：此时的年部分为：1970-01-01
 * @see Time
 */
fun Date.toTime(): Time = Time(this.hours, this.minutes, this.seconds)

/**
 * 转换成Sql对象
 */
fun Date.toSqlDate(): java.sql.Date = java.sql.Date(time)