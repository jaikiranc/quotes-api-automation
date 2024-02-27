package com.hmh.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber-reports/Cucumber.json", "rerun:target/cucumber-reports/rerun.txt" },
        features = "src/test/java/com/hmh/features/FavQuotes.feature",
        glue = "com.hmh.steps",
        monochrome = true,
        strict = true
       )
public class CucumberRunner {}

