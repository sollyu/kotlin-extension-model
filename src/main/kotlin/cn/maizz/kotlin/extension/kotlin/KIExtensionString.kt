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

package cn.maizz.kotlin.extension.kotlin

import java.nio.charset.Charset
import java.security.MessageDigest
import java.util.*
import java.util.regex.Pattern

interface KIExtensionString {

    /**
     * 随机字符串
     */
    fun String.Companion.random(length: Int): String = (1..length).map { "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"[Random().nextInt(62)] }.joinToString("")

    /**
     * 字符串打马赛克 例如：18888888888 => 188****8888
     *
     * @param char          打码显示的字符
     * @param startPosition 起始位置
     * @param endPosition   结束未知
     */
    fun String.mosaic(char: Char = '*', startPosition: Int = 1, endPosition: Int = length): String = StringBuilder().also { stringBuilder -> (0 until length).forEach { i -> stringBuilder.append(if (i in startPosition..endPosition) char else this@mosaic[i]) } }.toString()

    /**
     * 字符串进行Base64加密
     *
     * @param charset 字符串toByteArray时的编码
     */
    fun String.base64Encode(charset: Charset = Charsets.UTF_8): String = Base64.getEncoder().encodeToString(this.toByteArray(charset))

    /**
     * 字符串进行Base64解码
     *
     * @param charset 创建字符串时的编码
     */
    fun String.base64Decode(charset: Charset = Charsets.UTF_8): String = String(Base64.getDecoder().decode(this), charset)

    /**
     * 字符串进行MD5加密
     *
     * @param charset 字符串编码
     */
    fun String.md5(charset: Charset = Charsets.UTF_8): String = MessageDigest.getInstance("MD5").digest(this.toByteArray(charset)).joinToString("") { String.format("%02x", it) }

    /**
     * 字符串随机
     */
    fun String.random(length: Int = 10, random: Random = Random(System.currentTimeMillis())): String = (0 until length).map { this[random.nextInt(this.length)] }.joinToString("")

    /**
     * 判断是否包含中文
     */
    fun String.isContainChinese(): Boolean = this.contains(Pattern.compile("[\u4e00-\u9fa5]").toRegex())

    /**
     * 判断是否一个邮箱
     */
    fun String.isEmailValid(): Boolean = Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(this).matches()

    /**
     * 判断是否一个手机号码, 目前仅支持中国手机号码检测
     */
    fun String.isPhoneNumber(): Boolean = Pattern.compile("^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(14[5-9])|(166)|(19[8,9])|)\\d{8}$").matcher(this).matches()

    /**
     * @param endIndex 结束位置
     */
    fun String.toUpperCase(endIndex: Int): String = this.substring(0, endIndex).toUpperCase() + this.substring(endIndex)

    /**
     * @param endIndex 结束位置
     */
    fun String.toLowerCase(endIndex: Int): String = this.substring(0, endIndex).toLowerCase() + this.substring(endIndex)
}