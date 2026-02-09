**This is the template README. Please update this with project specific content.**

# securities-transfer-charge-frontend-ui-tests

UI journey tests suite for the [securities-transfer-charge-reg-frontend](https://github.com/hmrc/securities-transfer-charge-reg-frontend) using SeleniumWebdriver with ScalaTest.

## Pre-requisites

### Services

Start Mongo Docker container as follows:

```bash
docker run --rm -d -p 27017:27017 --name mongo percona/percona-server-mongodb:6.0
```

To start the required services via [service manager](https://github.com/hmrc/sm2), run:

```bash
sm2 --start STAMP_TAXES_ON_SHARES_ALL
```

## Tests

Run tests as follows:

* Argument `<browser>` must be `chrome`, `edge`, or `firefox`.
* Argument `<environment>` must be `local`, `dev`, `qa` or `staging`.

```bash
sbt clean -Dbrowser="<browser>" -Denvironment="<environment>" test testReport
```

To run the UI tests locally, execute the script:

```bash
./run-tests.sh <browser> <environment>
```

### ZAP tests

The `run_zap_tests.sh` script uses [dast-config-manager](https://github.com/hmrc/dast-config-manager) to run ZAP tests locally using the DAST Docker image.

To run the ZAP tests locally, execute the script:

```bash
./run_zap_tests.sh
```

## Scalafmt

Check all project files are formatted as expected as follows:

```bash
sbt scalafmtCheckAll scalafmtCheck
```

Format `*.sbt` and `project/*.scala` files as follows:

```bash
sbt scalafmtSbt
```

Format all project files as follows:

```bash
sbt scalafmtAll
```

## License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").
