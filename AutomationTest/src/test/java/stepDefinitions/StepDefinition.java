package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

    @Given("^User is at Home page$")
    public void user_is_at_home_page() throws Throwable {
        //throw new PendingException();
    	System.out.println("home page");
    }

    @When("^User enters valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_valid_something_and_something(String strArg1, String strArg2) throws Throwable {
        //throw new PendingException();
    	System.out.println(strArg1+" "+strArg2);
    }

    @Then("^Login is \"([^\"]*)\"$")
    public void login_is(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    	System.out.println(arg1);
    }

}
