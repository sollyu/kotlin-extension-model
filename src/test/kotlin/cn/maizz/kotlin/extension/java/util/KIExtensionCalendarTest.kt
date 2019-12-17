package cn.maizz.kotlin.extension.java.util

import org.junit.Assert
import org.junit.Test
import java.util.*

class KIExtensionCalendarTest {

    @Test
    fun testFormTimestamp() {
        Assert.assertEquals(Calendar.getInstance().formTimestamp(666220860000).getYear(), 1991)
        Assert.assertEquals(Calendar.getInstance().formTimestamp(666220860000).getMonth(), 1)
        Assert.assertEquals(Calendar.getInstance().formTimestamp(666220860000).getDay(), 11)
        Assert.assertEquals(Calendar.getInstance().formTimestamp(666220860000).getHour(), 5)
        Assert.assertEquals(Calendar.getInstance().formTimestamp(666220860000).getMinute(), 21)
        Assert.assertEquals(Calendar.getInstance().formTimestamp(666220860000).getSecond(), 0)
    }
}