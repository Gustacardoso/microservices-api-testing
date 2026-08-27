
# microservices-api-testing

[![CI](https://github.com/Gustacardoso/api-test-automation-framework/actions/workflows/ci.yml/badge.svg)](https://github.com/Gustacardoso/api-test-automation-framework/actions/workflows/ci.yml)

## Overview

A test automation framework developed to validate RESTful APIs and microservices using Rest Assured and Java.

This project demonstrates API testing best practices including authentication, CRUD operations, response validation, schema validation, and automated reporting.

## Features

- CRUD API validation
- Authentication testing
- Request and response validation
- Status code validation
- JSON schema validation
- Automated reporting with Allure
- Parallel test execution
- REST microservices testing

## Tech Stack

- Java
- Rest Assured
- Maven
- TestNG
- Allure Reports
- Docker
- GitHub Actions

## Project Structure

```
src
├── main
│   ├── java/test          # shared base test configuration
│   └── resources          # JSON schemas used for contract validation
└── test
    ├── java/testSimulations   # CRUD tests for the simulacoes endpoint
    ├── java/testRestricted    # tests for the restricoes endpoint
    └── CenariosTest           # test scenario documentation
testng.xml                 # suite definition, runs test classes in parallel
Dockerfile                 # containerized test execution
docker-compose.yml         # convenience wrapper around the Docker image
.github/workflows/ci.yml   # CI pipeline (build, test, Allure report)
```

## Running Tests

Clone repository:

```
git clone https://github.com/Gustacardoso/api-test-automation-framework.git
```

Install dependencies:

```
mvn clean install
```

Execute the test suite (runs `testng.xml`, tests execute in parallel by class):

```
mvn test
```

By default the suite targets `http://localhost:8080/api`. Point it at a different environment with either system properties or environment variables:

```
mvn test -Dapi.baseUri=https://staging.example.com -Dapi.port=443
```

| System property | Environment variable | Default             |
|------------------|-----------------------|----------------------|
| `api.baseUri`    | `API_BASE_URI`        | `http://localhost`  |
| `api.basePath`   | `API_BASE_PATH`       | `/api`               |
| `api.port`       | `API_PORT`             | `8080`               |

## Reports

Test results are collected by the Allure TestNG listener. After running the suite, generate and open the HTML report:

```
mvn allure:report
mvn allure:serve
```

## Docker

Run the test suite in a container without installing Java or Maven locally:

```
docker compose run --rm api-tests
```

Override the target API with environment variables (defaults to `http://host.docker.internal:8080/api`, i.e. an API running on your host machine):

```
API_BASE_URI=http://my-api API_PORT=80 docker compose run --rm api-tests
```

## CI/CD

Every push and pull request to `main` triggers the GitHub Actions workflow at [`.github/workflows/ci.yml`](.github/workflows/ci.yml), which builds the project, runs the test suite, and publishes the Allure and Surefire reports as workflow artifacts. Configure repository variables `API_BASE_URI`, `API_BASE_PATH` and `API_PORT` to point CI at a reachable test environment.

## Test Coverage

- Create operations
- Retrieve operations
- Update operations
- Delete operations
- Authentication flows
- Business validations

## Author

Gustavo Cardoso da Silveira

Senior QA Automation Engineer
