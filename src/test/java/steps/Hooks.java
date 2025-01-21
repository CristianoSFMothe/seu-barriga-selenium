package steps;

import base.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static base.BaseSteps.screenshot;
import static support.BrowserFactory.killDriver;

public class Hooks {
    @Before
    public void BeforeAllScenario(Scenario _scenario) {
        BaseSteps.scenario = _scenario;
    }

    @After
    public void AfterAllScenario() {
        if (BaseSteps.scenario.isFailed()) {
            screenshot();
        }
        if (BaseSteps.closeBrowser)
            killDriver();
    }
}