package starter.Reqres.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get single user with id {int}")
    public void getSingleUserWithParameter(int id) {
        reqresAPI.getSingleUser(id);
    }
    @When("Send request to get single user")
    public void sendRequestToGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Response body page should contain id {int} first name {string} and last name {string}")
    public void responseBodyPageShouldContainIdFirstNameAndLastName(int id, String firstName, String lastName) {
        SerenityRest.then().body(ReqresResponses.ID,equalTo(id))
                .body(ReqresResponses.FIRST_NAME,equalTo(firstName))
                .body(ReqresResponses.LAST_NAME,equalTo(lastName));
    }

    @And("Get single user json schema validator")
    public void getSingleUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_VALIDATOR_FILE+"/GetSingleUserJsonSchemaValidator.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario5
    @Given("Get single user invalid id {string}")
    public void getSingleUserInvalidId(String id) {
        reqresAPI.getSingleUserInvalidValueString(id);
    }
    //Scenario6
    @Given("Get single user invalid id above expected value {int}")
    public void getSingleUserInvalidIdAboveExpectedValue(int id) {
        reqresAPI.getSingleUser(id);
    }

}
