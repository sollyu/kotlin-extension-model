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

package cn.maizz.kotlin.extension.java.io

import org.apache.commons.io.IOUtils
import java.io.InputStream
import java.nio.charset.Charset

/**
 * 对java.io.InputStream类进行增强
 */
interface KIExtensionInputStream {

    /**
     * 直接转换成string
     *
     * @param encoding 转码字符串编码
     */
    fun InputStream.toString(encoding: Charset) = IOUtils.toString(this, encoding)!!

    /**
     * 转换成ByteArray
     */
    fun InputStream.toByteArray(): ByteArray = IOUtils.toByteArray(this)

    /**
     * 转换成char array
     *
     * @param encoding 转码字符串编码
     */
    fun InputStream.toCharArray(encoding: Charset = Charset.forName("UTF-8")): CharArray = IOUtils.toCharArray(this, encoding)

    /**
     * 对比
     */
    fun InputStream.equal(inputStream: InputStream): Boolean = IOUtils.contentEquals(this, inputStream)
}