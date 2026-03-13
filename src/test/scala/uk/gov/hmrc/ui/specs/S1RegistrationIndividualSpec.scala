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

package uk.gov.hmrc.ui.specs

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.verbs.ShouldVerb
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.ui.pages.*
import uk.gov.hmrc.ui.pages.CommonPages.{AuthWizard, RegistrationCompletePage, RegistrationPage}
import uk.gov.hmrc.ui.pages.individualPages.*
import uk.gov.hmrc.ui.util.TestDataConstants.*
import uk.gov.hmrc.ui.util.TestDataGenerator.getUKPostCode

class S1RegistrationIndividualSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("STC frontend Individual Journeys") {
    Scenario("Register a user as an Individual") {
      Given("User enters login using the Authority Wizard page")
      AuthWizard.loginAsIndividual()

      When("User navigates to Registration start page")
      RegistrationPage.startRegistration()
      CheckYourDetailsPage.confirmDetails()

      And("User enters the required values - DOB, address, email, contact")
      DateOfBirthPage.enterDob(dateOfDoB, monthOfDoB, yearOfDoB)
      YourAddressPage.enterCountry(ukCountry)
      FindYourAddressPage.enterPostCode(getUKPostCode)
      SelectYourAddressPage.selectAddress()
      ConfirmYourAddressPage.confirm()
      EmailAddressPage.enterEmailAddress(emailAddress)
      ContactNumberPage.enterContactNumber(contactNumber)

      Then("User verifies success message is displayed")
      RegistrationCompletePage.validateRegistrationCompleteMessage(registrationComplete)
    }

    Scenario("Register a user as an Individual Using Manual Address Entry") {
      Given("User enters login using the Authority Wizard page")
      AuthWizard.loginAsIndividual()

      When("User navigates to Registration start page")
      RegistrationPage.startRegistration()
      CheckYourDetailsPage.confirmDetails()

      And("User enters the required values - DOB, address, email, contact")
      DateOfBirthPage.enterDob(dateOfDoB, monthOfDoB, yearOfDoB)
      YourAddressPage.enterCountry(ukCountry)
      FindYourAddressPage.clickEnterTheAddressManually()
      EnterYourAddressPage.enterAddressDetails(addressLine1, getUKPostCode)
      ConfirmYourAddressPage.confirm()
      EmailAddressPage.enterEmailAddress(emailAddress)
      ContactNumberPage.enterContactNumber(contactNumber)

      Then("User verifies success message is displayed")
      RegistrationCompletePage.validateRegistrationCompleteMessage(registrationComplete)
    }

    Scenario("Register a user as an Individual Using Non UK Address") {
      Given("User enters login using the Authority Wizard page")
      AuthWizard.loginAsIndividual()

      When("User navigates to Registration start page")
      RegistrationPage.startRegistration()
      CheckYourDetailsPage.confirmDetails()

      And("User enters the required values - DOB, address, email, contact")
      DateOfBirthPage.enterDob(dateOfDoB, monthOfDoB, yearOfDoB)
      YourAddressPage.enterCountry(nonUkCountry)
      EnterYourAddressPage.enterAddressDetails(addressLine1, nonUkPostCode)
      ConfirmYourAddressPage.confirm()
      EmailAddressPage.enterEmailAddress(emailAddress)
      ContactNumberPage.enterContactNumber(contactNumber)

      Then("User verifies success message is displayed")
      RegistrationCompletePage.validateRegistrationCompleteMessage(registrationComplete)
    }
  }
}
