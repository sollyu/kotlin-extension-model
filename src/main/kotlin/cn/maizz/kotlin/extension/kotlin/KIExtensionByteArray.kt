/*
 * Copyright 2018-2019 Sollyu, Wonium
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
 *
 */

package cn.maizz.kotlin.extension.kotlin

import java.security.MessageDigest


/**
 * 转换成16进制字符串
 */
fun ByteArray.toStringHex(): String = this.joinToString(separator = "") { it.toInt().and(0xff).toString(16).padStart(2, '0') }

/**
 * 计算MD5值
 */
fun ByteArray.md5(): String = MessageDigest.getInstance("MD5").digest(this).joinToString("") { String.format("%02x", it) }
