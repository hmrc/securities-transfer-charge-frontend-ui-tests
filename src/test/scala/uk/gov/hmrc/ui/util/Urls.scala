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

package uk.gov.hmrc.ui.util

import uk.gov.hmrc.ui.util.Env.baseUrl

object Urls extends Enumeration {
  val env: String = Option(System.getProperty("environment")).map(_.toLowerCase).getOrElse("local")

  val AUTH: String =
    if (env == "local")
      "auth-login-stub/gg-sign-in?continue=http%3A%2F%2Flocalhost%3A30037%2Fregister-securities-transfer-charge%2Fregister%2Fstart"
    else "/auth-login-stub/gg-sign-in?continue=%2Fregister-securities-transfer-charge%2Fregister%2Fstart"

  val GRS_INCORPORATED: String =
    if (env == "local") "http://localhost:9718/identify-your-incorporated-business/test-only/feature-switches"
    else baseUrl + "/identify-your-incorporated-business/test-only/feature-switches"

  val GRS_PARTNERSHIP: String =
    if (env == "local") "http://localhost:9722/identify-your-partnership/test-only/feature-switches"
    else baseUrl + "/identify-your-partnership/test-only/feature-switches"

  val GRS_TRUST: String =
    if (env == "local") "http://localhost:9725/identify-your-trust/test-only/feature-switches"
    else baseUrl + "/identify-your-trust/test-only/feature-switches"

  val GRS_UNINCORPORATED: String =
    if (env == "local") "http://localhost:9725/identify-your-unincorporated-association/test-only/feature-switches"
    else baseUrl + "/identify-your-unincorporated-association/test-only/feature-switches"

  val LOCAL   =
    "http://localhost:9949/"
  val QA      =
    "https://www.qa.tax.service.gov.uk/"
  val DEV     =
    "https://www.development.tax.service.gov.uk/"
  val STAGING =
    "https://www.staging.tax.service.gov.uk/"
}
