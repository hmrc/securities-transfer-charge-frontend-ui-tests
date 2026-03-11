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

package uk.gov.hmrc.ui.pages.businessPages.PrerequisitePages

import org.openqa.selenium.By
import org.scalatest.time.{Millis, Span}
import uk.gov.hmrc.ui.conf.TestConfiguration
import uk.gov.hmrc.ui.pages.CommonPages.AuthWizard.{click, url}
import uk.gov.hmrc.ui.pages.BasePage
import uk.gov.hmrc.ui.pages.businessPages.PrerequisitePages.IncorporatedBusinessPage.{eventually, timeout}

object UnincorporatedAssociationPage extends BasePage {

  override def pageUrl: String =
    s"${TestConfiguration.url("host")}/identify-your-unincorporated-association/test-only/feature-switches"

  override def pageTitle: String = "Choose which features to enable."

  val btnSubmit: By = By.cssSelector("button[type='submit'].govuk-button")

  private def ensureChecked(elementId: String): Unit =
    try {
      val elem = driver.findElement(By.id(elementId))
      try
        if (!elem.isSelected) {
          elem.click()
          eventually(timeout(Span(200, Millis))) {}
        }
      catch {
        case _: Throwable =>
          try {
            elem.click()
            eventually(timeout(Span(200, Millis))) {}
          } catch {
            case _: Throwable => ()
          }
      }
    } catch {
      case _: Throwable =>
    }

  def openEntityValidationService(): Unit = {
    navigateToPage(url + "/identify-your-unincorporated-association/test-only/feature-switches")
    ensureChecked("feature-switch.enable-full-trust-journey")
    ensureChecked("feature-switch.trust-verification-stub")
    ensureChecked("feature-switch.business-verification-stub")
    ensureChecked("feature-switch.enable-full-unincorporated-association-journey")
    ensureChecked("feature-switch.des-stub")
    ensureChecked("feature-switch.ct-reference-stub")

    for (i <- 1 to 5) {

      /** wait for 0.5 sec */
      eventually(timeout(Span(500, Millis))) {}
      click(btnSubmit)
    }
    eventually(timeout(Span(2000, Millis))) {}
  }
}
