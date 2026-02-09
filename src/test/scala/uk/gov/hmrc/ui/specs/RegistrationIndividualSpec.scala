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

package uk.gov.hmrc.ui.specs

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.verbs.ShouldVerb
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.ui.pages.*

class RegistrationIndividualSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("STC frontend Journeys") {
    Scenario("Register a user as an Individual") {
      Given("User enters login using the Authority Wizard page")
      AuthWizard.loginAsIndividual()

      When("User navigates to Registration start page")
      RegistrationPage.startRegistration()
      CheckYourDetailsPage.confirmDetails()

      And("User enters the required values - DOB, address, email, contact")
      DateOfBirthPage.enterDob("01", "01", "2000")
      YourAddressPage.enterCountry("United Kingdom")
      FindYourAddressPage.enterPostCode("NE325JU")
      SelectYourAddressPage.selectAddress()
      ConfirmYourAddressPage.confirm()
      EmailAddressPage.enterEmailAddress("abcd@xyz.com")
      ContactNumberPage.enterContactNumber("+44 1234567890")

      Then("User verifies success message is displayed")
      RegistrationCompletePage.validateRegistrationCompleteMessage("Registration complete")
    }
  }
}
