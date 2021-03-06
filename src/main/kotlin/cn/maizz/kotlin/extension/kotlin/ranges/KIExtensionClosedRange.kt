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

package cn.maizz.kotlin.extension.kotlin.ranges

import java.util.*

fun ClosedRange<Int>.random(): Int = Random().nextInt((endInclusive + 1) - start) + start

fun ClosedRange<Char>.random(length: Int) = (1..length).map { (Random().nextInt(endInclusive.toInt() - start.toInt()) + start.toInt()).toChar() }.joinToString("")
