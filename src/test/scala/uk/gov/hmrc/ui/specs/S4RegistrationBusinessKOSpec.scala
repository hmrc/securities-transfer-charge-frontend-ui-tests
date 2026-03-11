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
import uk.gov.hmrc.ui.pages.CommonPages.{AuthWizard, RegistrationPage}
import uk.gov.hmrc.ui.pages.KOPage.{general, nonUk, scottish, trust}
import uk.gov.hmrc.ui.pages.businessPages.SelectYourBusinessPartnershipTypePage.{General, Scottish}
import uk.gov.hmrc.ui.pages.businessPages.SelectYourBusinessTypePage.{Partnership, SoleTrader}
import uk.gov.hmrc.ui.pages.businessPages.UkOrNotPage.No
import uk.gov.hmrc.ui.pages.businessPages.{SelectYourBusinessPartnershipTypePage, SelectYourBusinessTypePage, UkOrNotPage}

class S4RegistrationBusinessKOSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("STC frontend Organisation Journeys") {

    Scenario("Error scenario for Register Business when non uk") {
      Given("User enters login using the Authority Wizard page")
      AuthWizard.loginAsOrganisation()

      When("User navigates to Registration start page")
      RegistrationPage.startRegistration()
      UkOrNotPage.confirmDetails(No)

      Then("User verifies KO message is displayed")
      KOPage.validateErrorMessage(nonUk)
    }

    Scenario("Error scenario for Register Business when business type as sole trader") {
      Given("User enters login using the Authority Wizard page")
      AuthWizard.loginAsOrganisation()

      When("User navigates to Registration start page")
      RegistrationPage.startRegistration()
      UkOrNotPage.confirmDetails()
      SelectYourBusinessTypePage.selectType(SoleTrader)

      Then("User verifies KO message is displayed")
      KOPage.validateErrorMessage(trust)
    }

    Scenario("Error scenario for Register Business - Partnership : General") {
      Given("User enters login using the Authority Wizard page")
      AuthWizard.loginAsOrganisation()

      When("User navigates to Registration start page")
      RegistrationPage.startRegistration()
      UkOrNotPage.confirmDetails()

      And("User selects the business type")
      SelectYourBusinessTypePage.selectType(Partnership)

      And("User navigates through GRS flow")
      SelectYourBusinessPartnershipTypePage.selectType(General)

      Then("User verifies KO message is displayed")
      KOPage.validateErrorMessage(general)
    }

    Scenario("Error scenario for Register Business - Partnership : Scottish") {
      Given("User enters login using the Authority Wizard page")
      AuthWizard.loginAsOrganisation()

      When("User navigates to Registration start page")
      RegistrationPage.startRegistration()
      UkOrNotPage.confirmDetails()

      And("User selects the business type")
      SelectYourBusinessTypePage.selectType(Partnership)

      And("User navigates through GRS flow")
      SelectYourBusinessPartnershipTypePage.selectType(Scottish)

      Then("User verifies KO message is displayed")
      KOPage.validateErrorMessage(scottish)
    }
  }
}
