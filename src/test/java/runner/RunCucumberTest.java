package runner;

import base.BaseSteps;
import com.rajatthareja.reportbuilder.Color;
import com.rajatthareja.reportbuilder.ReportBuilder;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Register",
        features = "src/test/resources/features",	            // Path: features = "classpath:features"
        glue = "steps",					                        // Path: Steps
        monochrome = false,							            // Cores no Terminal default: false
        snippets = CucumberOptions.SnippetType.CAMELCASE,		// METHODOS do Steps em CAMELCASE
        dryRun = false,								            // Validar Steps sem executar o teste
        plugin = {									            // Plugins Cucumber para possivel integracao com Jenkins
                "pretty",
                "html:target/cucumber/index.html",
                "json:target/cucumber/index.json"
        }
)

public class RunCucumberTest {
    @BeforeClass
    public static void BeforeAllTest() {
        BaseSteps.OpenBrowser();
    }

    @AfterClass
    public static void AfterAllTest() {
        // Report-Builder
        List<Object> cucumberJsonReports = new ArrayList<>();
        ReportBuilder reportBuilder = new ReportBuilder();
        String dataReport = (new SimpleDateFormat("MMM dd, yyyy (EEE) | HH:mm:ss zzz")).format(new Date());

        cucumberJsonReports.add(new File("target/cucumber/index.json"));
        reportBuilder.setReportDirectory("target/report-builder/");
        reportBuilder.setReportFileName("index");
        reportBuilder.setReportColor(Color.CYAN); // http://materializecss.com/color.html
        reportBuilder.setReportTitle("Testes E2E - Adopet");
        reportBuilder.setAdditionalInfo("Date", dataReport);
        reportBuilder.setAdditionalInfo("Environment", "HML");
        reportBuilder.setAdditionalInfo("Browser", "N/A");
        reportBuilder.setAdditionalInfo("Url", "https://seubarriga.wcaquino.me/login");
        reportBuilder.setAdditionalInfo("Runtime", "N/A");
        reportBuilder.build(cucumberJsonReports);
    }
}