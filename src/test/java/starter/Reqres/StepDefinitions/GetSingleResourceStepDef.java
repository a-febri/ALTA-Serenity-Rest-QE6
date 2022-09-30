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

public class GetSingleResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get single resource with id {int}")
    public void getSingleResourceWithValidId(int id) {
        reqresAPI.getSingleResource(id);
    }

    @When("Send request to get single resource")
    public void sendRequestToGetSingleResource() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE);
    }

    @And("Response body page should be id is {int} name {string} year {int} color {string} and pantone value {string}")
    public void responseBodyPageShouldBeIdIsNameYearColorAndPantoneValue(int id, String name, int year, String color, String pantoneValue) {
        SerenityRest.then().body(ReqresResponses.ID,equalTo(id))
                .body(ReqresResponses.NAME_SINGLE_RESOURCE,equalTo(name))
                .body(ReqresResponses.YEAR,equalTo(year))
                .body(ReqresResponses.COLOR,equalTo(color))
                .body(ReqresResponses.PANTONE_VALUE,equalTo(pantoneValue));

    }
    @And("Get single resource json schema validator")
    public void getSingleResourceJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_VALIDATOR_FILE+"/GetSingleResourceJsonSchemaValidator.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //Scenario2
    @Given("Get single resource with id {string}")
    public void getSingleResourceWithId(String id) {
        reqresAPI.getSingleResources(id);
    }
}
