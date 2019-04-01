package cn.maizz.kotlin.extension.kotlin

import org.junit.Assert
import org.junit.Test
import java.nio.charset.Charset
import cn.maizz.kotlin.extension.kotlin.KIExtensionString

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
    fun testMd5_16() {
        Assert.assertEquals("王大弎".md5_16(), "826ee322d5323285")
        Assert.assertEquals("admin@sollyu.com".md5_16(), "3be68ba63c900621")
    }

    @Test
    fun testSha1() {
        Assert.assertEquals("王大弎".sha1(), "844a31e8b6b545b96d021d45682d6581eaec9c70")
        Assert.assertEquals("admin@sollyu.com".sha1(), "2a6645486e1cf0f4ec4f3223e6368060e8d74293")
    }

    @Test
    fun testSha256() {
        Assert.assertEquals("王大弎".sha256(), "e49ae1d954a354cb29f44f365e1518dff18136af1f35c382eb000c038a972007")
        Assert.assertEquals("admin@sollyu.com".sha256(), "615d8639456fe576e259f1152793b2dc700bf051f179546cd5ee3dcc218f7460")
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