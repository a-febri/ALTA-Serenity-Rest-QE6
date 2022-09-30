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

public class GetListResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;
//Scenario1
    @Given("Get list resource with valid path {string}")
    public void getListResourceWithValidPath(String path) {
        reqresAPI.getListResource(path);
    }

    @When("Send request to get list resource")
    public void sendRequestToGetListResource() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE);
    }

    @And("Response body page should be page {int} and total pages are {int}")
    public void responseBodyPageShouldBePageAndTotalPageIs(int page, int totalPage) {
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page))
                .body(ReqresResponses.TOTAL_PAGE,equalTo(totalPage));
    }
    @And("Get list resource json schema validator")
    public void getListResourceJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_VALIDATOR_FILE+"/GetListResourceJsonSchemaValidator.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
//Scenario2
    @Given("Get list resource with invalid path {string}")
    public void getListResourceWithInvalidPath(String path) {
        reqresAPI.getListResource(path);
    }
//Scenario3
    @Given("Get list resource with parameter page {int}")
    public void getListResourceWithParameterPage(int page) {
        reqresAPI.getListResourceParam(page);
    }
    @When("Send request to get list resource with param")
    public void sendRequestToGetListResourceWithParam() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE_PARAM);
    }
    @And("Response body page should contain page {int}")
    public void responseBodyPageShouldContainPage(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
    }
}
