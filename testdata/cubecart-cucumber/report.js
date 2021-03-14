$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/backendtestfeatures/weatherapi.feature");
formatter.feature({
  "name": "user should be able to get weather forecast data using open weather map API",
  "description": "  user should call the weather api with valid api key and get forecast information",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "user can get forecast data for any city",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@weatherApiTest"
    }
  ]
});
formatter.step({
  "name": "a \"\u003ccity\u003e\" and \"\u003ccountry\u003e\" and api key",
  "keyword": "Given "
});
formatter.step({
  "name": "a user calls the weather api with the api key",
  "keyword": "When "
});
formatter.step({
  "name": "user should see the weather data for the city",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "city",
        "country"
      ]
    },
    {
      "cells": [
        "London",
        "uk"
      ]
    },
    {
      "cells": [
        "Istanbul",
        "tr"
      ]
    },
    {
      "cells": [
        "Toronto",
        "ca"
      ]
    },
    {
      "cells": [
        "chicago",
        "us"
      ]
    },
    {
      "cells": [
        "tokyo",
        "jp"
      ]
    },
    {
      "cells": [
        "urumqi",
        "cn"
      ]
    }
  ]
});
formatter.scenario({
  "name": "user can get forecast data for any city",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@weatherApiTest"
    }
  ]
});
formatter.step({
  "name": "a \"London\" and \"uk\" and api key",
  "keyword": "Given "
});
formatter.match({
  "location": "weatherApiSteps.aAndAndApiKey(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a user calls the weather api with the api key",
  "keyword": "When "
});
formatter.match({
  "location": "weatherApiSteps.aUserCallsTheWeatherApiWithTheApiKey()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should see the weather data for the city",
  "keyword": "Then "
});
formatter.match({
  "location": "weatherApiSteps.userShouldSeeTheWeatherDataForTheCity()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "user can get forecast data for any city",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@weatherApiTest"
    }
  ]
});
formatter.step({
  "name": "a \"Istanbul\" and \"tr\" and api key",
  "keyword": "Given "
});
formatter.match({
  "location": "weatherApiSteps.aAndAndApiKey(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a user calls the weather api with the api key",
  "keyword": "When "
});
formatter.match({
  "location": "weatherApiSteps.aUserCallsTheWeatherApiWithTheApiKey()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should see the weather data for the city",
  "keyword": "Then "
});
formatter.match({
  "location": "weatherApiSteps.userShouldSeeTheWeatherDataForTheCity()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "user can get forecast data for any city",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@weatherApiTest"
    }
  ]
});
formatter.step({
  "name": "a \"Toronto\" and \"ca\" and api key",
  "keyword": "Given "
});
formatter.match({
  "location": "weatherApiSteps.aAndAndApiKey(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a user calls the weather api with the api key",
  "keyword": "When "
});
formatter.match({
  "location": "weatherApiSteps.aUserCallsTheWeatherApiWithTheApiKey()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should see the weather data for the city",
  "keyword": "Then "
});
formatter.match({
  "location": "weatherApiSteps.userShouldSeeTheWeatherDataForTheCity()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "user can get forecast data for any city",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@weatherApiTest"
    }
  ]
});
formatter.step({
  "name": "a \"chicago\" and \"us\" and api key",
  "keyword": "Given "
});
formatter.match({
  "location": "weatherApiSteps.aAndAndApiKey(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a user calls the weather api with the api key",
  "keyword": "When "
});
formatter.match({
  "location": "weatherApiSteps.aUserCallsTheWeatherApiWithTheApiKey()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should see the weather data for the city",
  "keyword": "Then "
});
formatter.match({
  "location": "weatherApiSteps.userShouldSeeTheWeatherDataForTheCity()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "user can get forecast data for any city",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@weatherApiTest"
    }
  ]
});
formatter.step({
  "name": "a \"tokyo\" and \"jp\" and api key",
  "keyword": "Given "
});
formatter.match({
  "location": "weatherApiSteps.aAndAndApiKey(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a user calls the weather api with the api key",
  "keyword": "When "
});
formatter.match({
  "location": "weatherApiSteps.aUserCallsTheWeatherApiWithTheApiKey()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should see the weather data for the city",
  "keyword": "Then "
});
formatter.match({
  "location": "weatherApiSteps.userShouldSeeTheWeatherDataForTheCity()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "user can get forecast data for any city",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@weatherApiTest"
    }
  ]
});
formatter.step({
  "name": "a \"urumqi\" and \"cn\" and api key",
  "keyword": "Given "
});
formatter.match({
  "location": "weatherApiSteps.aAndAndApiKey(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a user calls the weather api with the api key",
  "keyword": "When "
});
formatter.match({
  "location": "weatherApiSteps.aUserCallsTheWeatherApiWithTheApiKey()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should see the weather data for the city",
  "keyword": "Then "
});
formatter.match({
  "location": "weatherApiSteps.userShouldSeeTheWeatherDataForTheCity()"
});
formatter.result({
  "status": "passed"
});
});