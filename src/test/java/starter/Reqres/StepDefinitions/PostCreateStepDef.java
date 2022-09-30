package starter.Reqres.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostCreateStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Post create new user")
    public void postCreateNewUser() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostCreateNewUser.json");
        reqresAPI.postCreateNewUser(json);
    }

    @When("Send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER);
    }

    @Then("Should return {int} created")
    public void shouldReturnCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }
    @And("Post create new user json schema validator")
    public void postCreateNewUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_VALIDATOR_FILE +"/PostCreateNewUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //Scenario2
    @Given("Post create new user input job empty name")
    public void postCreateNewUserInputJobEmptyName() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostCreateNewUserEmptyName.json");
        reqresAPI.postCreateNewUser(json);
    }

    @Then("Should return {int} bad request")
    public void shouldReturnBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);

    }

    //Scenario3
    @Given("Post create new user input name empty job")
    public void postCreateNewUserInputNameEmptyJob() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostCreateNewUserEmptyJob.json");
        reqresAPI.postCreateNewUser(json);
    }
    //Scenario4
    @Given("Post create new user empty name and job")
    public void postCreateNewUserEmptyNameAndJob() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostCreateNewUserEmptyAllValue.json");
        reqresAPI.postCreateNewUser(json);
    }
}
