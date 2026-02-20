/*
 * Copyright 2025 HM Revenue & Customs
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

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By

object KOPage extends BasePage {

  override def pageUrl: String = "/register-securities-transfer-charge/lowConfidenceKickOut"

  // placeholder yet to finalize the title
  override def pageTitle: String =
    "Before you use the service - securities-transfer-charge-reg-frontend - GOV.UK"

  def validateLowClErrorMessage(): Unit = {

    val expectedHeading = "Before you use the service"
    val expectedBody    =
      "Before you can tell us about a securities transfer you need to provide more information to confirm your identity."

    val headingText = driver.findElement(By.cssSelector("h1")).getText.trim
    val bodyText    = driver.findElement(By.cssSelector(".govuk-body")).getText.trim

    assert(
      headingText == expectedHeading,
      s"Expected heading text '$expectedHeading' but found '$headingText'"
    )
    assert(
      bodyText == expectedBody,
      s"Expected heading text '$expectedBody' but found '$bodyText'"
    )
  }

  def validateCheckYourDetailsErrorMessage(): Unit = {

    val expectedHeading = "You must update the details on your government gateway account"
    val expectedBody    =
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

    val headingText = driver.findElement(By.cssSelector("h1")).getText.trim
    val bodyText    = driver.findElement(By.cssSelector(".govuk-body")).getText.trim

    assert(
      headingText == expectedHeading,
      s"Expected heading text '$expectedHeading' but found '$headingText'"
    )
    assert(
      bodyText == expectedBody,
      s"Expected heading text '$expectedBody' but found '$bodyText'"
    )
  }
}
