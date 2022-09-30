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

public class GetListUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get list user with parameter page {int}")
    public void getListUserWithParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request to get list user")
    public void sendRequestToGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Should return {int} OK")
    public void shouldReturnOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
//        SerenityRest.then().body("page",equalTo(page)); akan sama dengan di bawah
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
    }
    @And("Get list user json schema validation")
    public void getListUserJsonSchemaValidation() {
        File json = new File(ReqresAPI.JSON_SCHEMA_VALIDATOR_FILE +"/GetListUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //Scenario2
    @Given("Get list user with invalid parameter page {string}")
    public void getListUserWithInvalidParameterPage(String page) {
        reqresAPI.getListUsersInvalidPage(page);
    }
    @Then("Should return {int} not found")
    public void shouldReturnNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
}
