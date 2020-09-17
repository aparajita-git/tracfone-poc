package com.tracfone.tests.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"./src/test/java/features/TrainingRequest.feature"}
         ,glue = "com.tracfone.tests.stepdefinitions"
          ,tags = {"@Scenario_02"}
     //  ,tags = {"@Regression"}
)

public class TrainingRequestTRTest {

}