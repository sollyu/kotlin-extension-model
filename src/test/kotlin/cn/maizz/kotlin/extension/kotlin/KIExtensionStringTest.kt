package cn.maizz.kotlin.extension.kotlin

import org.junit.Assert
import org.junit.Test
import java.nio.charset.Charset

class KIExtensionStringTest : KIExtensionString {

    @Test
    fun testMosaic() {
        Assert.assertEquals("18888888888".mosaic('*', startPosition = 3, endPosition = 6), "188****8888")
        Assert.assertEquals("王大弎".mosaic('*', startPosition = 1, endPosition = 1), "王*弎")
        Assert.assertEquals("王大弎".mosaic('*', startPosition = 1, endPosition = 2), "王**")
        Assert.assertEquals("王大弎".mosaic('x', startPosition = 1, endPosition = 1), "王x弎")
        Assert.assertEquals("王大弎".mosaic('某', startPosition = 1, endPosition = 2), "王某某")
    }

    @Test
    fun testBase64Encode() {
        Assert.assertEquals("王大弎".base64Encode(Charset.forName("UTF-8")), "546L5aSn5byO")
        Assert.assertEquals("admin@sollyu.com".base64Encode(Charset.forName("UTF-8")), "YWRtaW5Ac29sbHl1LmNvbQ==")
    }

    @Test
    fun testBase64Decode() {
        Assert.assertEquals("546L5aSn5byO".base64Decode(Charset.forName("UTF-8")), "王大弎")
        Assert.assertEquals("YWRtaW5Ac29sbHl1LmNvbQ==".base64Decode(Charset.forName("UTF-8")), "admin@sollyu.com")
    }

    @Test
    fun testMd5() {
        Assert.assertEquals("王大弎".md5(), "c2b23999826ee322d5323285c662fed7")
        Assert.assertEquals("admin@sollyu.com".md5(), "e1203b403be68ba63c9006218cc41e68")
    }

    @Test
    fun testIsContainChinese() {
        Assert.assertEquals("王大弎".isContainChinese(), true)
        Assert.assertEquals("i love 王大弎".isContainChinese(), true)
        Assert.assertEquals("i love china".isContainChinese(), false)
        Assert.assertEquals("i love china.".isContainChinese(), false)
        Assert.assertEquals("i love china。".isContainChinese(), false)
    }

    @Test
    fun testIsEmailValid() {
        Assert.assertEquals("admin@maizz.cn".isEmailValid(), true)
        Assert.assertEquals("admin-sollyu@maizz.cn".isEmailValid(), true)
        Assert.assertEquals("admin_sollyu@maizz.cn".isEmailValid(), true)
        Assert.assertEquals("1888888888@maizz.cn".isEmailValid(), true)
        Assert.assertEquals("188888888.8@maizz.cn".isEmailValid(), true)
        Assert.assertEquals(".188888888.8@maizz.cn".isEmailValid(), false)
        Assert.assertEquals("_188888888.8@maizz.cn".isEmailValid(), true)
        Assert.assertEquals("_1 88888888.8@maizz.cn".isEmailValid(), false)
    }

    @Test
    fun testIsPhoneNumber() {
        Assert.assertEquals("18888888888".isPhoneNumber(), true)
    }

    @Test
    fun testToUpperCase() {
        Assert.assertEquals("i love china".toUpperCase(3), "I Love china")
    }

    @Test
    fun testToLowerCase() {
        Assert.assertEquals("I Love china".toLowerCase(3), "i love china")
    }
}