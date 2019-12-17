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

import java.security.MessageDigest
import java.util.*


fun ByteArray.toHexString(): String = this.joinToString("") { String.format("%02x", it) }

fun ByteArray.base64Encode(): ByteArray = Base64.getEncoder().encode(this)

fun ByteArray.base64Decode(): ByteArray = Base64.getDecoder().decode(this)

fun ByteArray.md5(): ByteArray = MessageDigest.getInstance("MD5").digest(this)

fun ByteArray.sha1(): ByteArray = MessageDigest.getInstance("SHA-1").digest(this)

fun ByteArray.sha256(): ByteArray = MessageDigest.getInstance("SHA-256").digest(this)