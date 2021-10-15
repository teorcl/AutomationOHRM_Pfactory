package co.com.sofka.runner.orangerecruitmentvacancies;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        plugin = {"pretty","html:target/cucumber-report/cucumber.html"},
        features = {"src/test/resources/features/webui/orangerecruitmentvacancies/orangerecruitmentvacancies.feature"},

        glue = {"co.com.sofka.stepdefinition.orangerecruitmentvacancies"},
        tags = "not @ignore"
)
public class OrangeRecruitmentVacanciesCucumberTest {
}
