package cn.maizz.kotlin.extension.java.util

import org.junit.Assert
import org.junit.Test
import java.util.*
import java.util.concurrent.TimeUnit

class KIExtensionDateTest : KIExtensionDate {

    @Test
    fun testFormat() {
        Assert.assertEquals(Date(666220860000).format("yyyy-MM-dd HH:mm:ss"), "1991-02-11 05:21:00")
        Assert.assertEquals(Date(666220860000).format("yyyy/MM/dd HH:mm:ss"), "1991/02/11 05:21:00")
    }

    @Test
    fun testAdd() {
        Assert.assertEquals(Date(666220860000).add(Calendar.DAY_OF_MONTH, 4).format("yyyy-MM-dd HH:mm:ss"), "1991-02-15 05:21:00")
        Assert.assertEquals(Date(666220860000).add(Calendar.MONTH       , 4).format("yyyy/MM/dd HH:mm:ss"), "1991/06/11 05:21:00")
        Assert.assertEquals(Date(666220860000).add(Calendar.MINUTE      , 4).format("yyyy/MM/dd HH:mm:ss"), "1991/02/11 05:25:00")
        Assert.assertEquals(Date(666220860000).add(Calendar.SECOND      , 4).format("yyyy/MM/dd HH:mm:ss"), "1991/02/11 05:21:04")

        Assert.assertEquals(Date(666220860000).add(Calendar.DAY_OF_MONTH, -1).format("yyyy-MM-dd HH:mm:ss"), "1991-02-10 05:21:00")
        Assert.assertEquals(Date(666220860000).add(Calendar.MINUTE      , -1).format("yyyy-MM-dd HH:mm:ss"), "1991-02-11 05:20:00")
    }

    @Test
    fun testIsToday() {
        // 请注意，如果您测试的时间在23:30之后，此处会有错误
        Assert.assertEquals(Date().add(Calendar.MINUTE      , 30 ).isToday(), true)
        Assert.assertEquals(Date().add(Calendar.MINUTE      , -30).isToday(), true)
        Assert.assertEquals(Date().add(Calendar.DAY_OF_MONTH, 30 ).isToday(), false)
        Assert.assertEquals(Date().add(Calendar.DAY_OF_MONTH, -30).isToday(), false)
    }

    @Test
    fun testIsTomorrow() {
        // 请注意，如果您测试的时间在23:30之后，此处会有错误
        Assert.assertEquals(Date().add(Calendar.MINUTE      , 30 ).isTomorrow(), false)
        Assert.assertEquals(Date().add(Calendar.MINUTE      , -30).isTomorrow(), false)
        Assert.assertEquals(Date().add(Calendar.DAY_OF_MONTH, 1  ).isTomorrow(), true)
        Assert.assertEquals(Date().add(Calendar.DAY_OF_MONTH, -1 ).isTomorrow(), false)
    }

    @Test
    fun testIsFuture() {
        Assert.assertEquals(Date().add(Calendar.MINUTE      , 30 ).isFuture(), true)
        Assert.assertEquals(Date().add(Calendar.MINUTE      , -30).isFuture(), false)
        Assert.assertEquals(Date().add(Calendar.DAY_OF_MONTH, 30 ).isFuture(), true)
        Assert.assertEquals(Date().add(Calendar.DAY_OF_MONTH, -30).isFuture(), false)
    }

    @Test
    fun testDay() {
        Assert.assertEquals(Date(666220860000)      .format("yyyy-MM-dd HH:mm:ss"), "1991-02-11 05:21:00")
        Assert.assertEquals(Date(666220860000).day().format("yyyy-MM-dd HH:mm:ss"), "1991-02-11 00:00:00")
        Assert.assertEquals(Date(666220860000).day().format("yyyy/MM/dd HH:mm:ss"), "1991/02/11 00:00:00")
    }

    @Test
    fun testDayMonth() {
        Assert.assertEquals(Date(666220860000).format("yyyy-MM-dd HH:mm:ss"), "1991-02-11 05:21:00")
        Assert.assertEquals(Date(666220860000).dayMonth(), 11)
    }

    @Test
    fun testSub() {
        val startDate:Date = Date(666220860000)
        val endDate:Date = Date(666566460000)

        Assert.assertEquals(startDate.format("yyyy-MM-dd HH:mm:ss"), "1991-02-11 05:21:00")
        Assert.assertEquals(endDate  .format("yyyy-MM-dd HH:mm:ss"), "1991-02-15 05:21:00")
        Assert.assertEquals(startDate.sub(endDate).time, TimeUnit.HOURS.toMillis(-96))
        Assert.assertEquals(startDate.sub(endDate).time, TimeUnit.DAYS.toMillis(-4))
        Assert.assertEquals(endDate.sub(startDate).time, TimeUnit.HOURS.toMillis(96))
        Assert.assertEquals(endDate.sub(startDate).time, TimeUnit.DAYS.toMillis(4))
    }
}