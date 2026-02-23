/*
 * Copyright 2026 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.util

import scala.util.Random

object TestDataGenerator {

  private val validPrefixLetters = "ABCEGHJKLMNPRSTWXYZ" // Excludes D, F, I, Q, U, V
  private val suffixLetters      = "ABCD"

  def generateNino(): String = {
    val random = new Random()

    val firstLetter  = validPrefixLetters(random.nextInt(validPrefixLetters.length))
    val secondLetter = validPrefixLetters(random.nextInt(validPrefixLetters.length))

    val digits = (1 to 6).map(_ => random.nextInt(10)).mkString

    val suffix = suffixLetters(random.nextInt(suffixLetters.length))

    s"$firstLetter$secondLetter$digits$suffix"
  }

  def generateRandomString(length: Int): String = {
    val chars  = ('A' to 'Z') ++ ('a' to 'z') ++ ('0' to '9')
    val random = new Random()
    (1 to length).map(_ => chars(random.nextInt(chars.length))).mkString
  }

  def generateNino(prefix: String = "AA"): String = {
    val num    = Random.nextInt(1000000)
    val suffix = "C"
    f"$prefix$num%06d$suffix"
  }

  val testNino: String = generateNino("AB")
}
