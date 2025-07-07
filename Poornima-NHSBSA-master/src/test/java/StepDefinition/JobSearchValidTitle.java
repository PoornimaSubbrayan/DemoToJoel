package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchValidJobTitle;
import utility.BrowserDriver;


public class JobSearchValidTitle extends SearchValidJobTitle {

    @Given ("I am a job seeker on NHS Jobs website using {string} for valid title search")
        public void nhs_home_page(String browser) throws Throwable {
            BrowserDriver.invokedriver(browser);
        }

    @When ("I enter correct job title and location in search")
    public void user_enter_correct_job_title_location() throws Throwable {
        search_valid_job_title_location();
    }

    @Then("I should get a list of jobs which matches my search criteria entered")
    public void i_should_get_a_jobs_which_matches_my_preferences() throws Throwable {
        search_result_valid_job_title();
    }
}
