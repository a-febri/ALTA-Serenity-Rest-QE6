package starter.Reqres.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;

import java.io.File;

public class PutUpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
    //Scenario1
    @Given("put update user with id {int}")
    public void putUpdateUserWithIdId(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PutUpdateUser.json");
        reqresAPI.putUpdateUser(id, json);
    }
    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }
    @And("Put update user json schema validator")
    public void putUpdateUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_VALIDATOR_FILE+"/PutUpdateUserJsonSchemaValidator.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //Scenario2
    @Given("Put update user with id {int} only input name")
    public void putUpdateUserWithIdIdOnlyInputName(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PutUpdateUserEmptyName.json");
        reqresAPI.putUpdateUser(id, json);
    }
    //Scenario3
    @Given("Put update user with id {int} only input job")
    public void putUpdateUserWithIdIdOnlyInputJob(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PutUpdateUserEmptyJob.json");
        reqresAPI.putUpdateUser(id, json);
    }
    //Scenario4
    @Given("Put update user with id {int} empty name empty job")
    public void putUpdateUserWithIdEmptyNameEmptyJob(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PutUpdateUserEmptyAllValue.json");
        reqresAPI.putUpdateUser(id, json);
    }
    //Scenario5
    @Given("Put update user with invalid path {string} valid json")
    public void putUpdateUserWithInvalidPathEmptyNameEmptyJob(String path) {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PutUpdateUser.json");
        reqresAPI.putUpdateUserInvalidPath(path, json);
    }

    @When("Send request put update user invalid path")
    public void sendRequestPutUpdateUserInvalidPath() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER_INVALID_PATH);
    }

    //Scenario6
    @Given("Put update user with invalid path {string} with special char valid json")
    public void putUpdateUserWithInvalidPathWithSpecialCharValidJson(String path) {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PutUpdateUser.json");
        reqresAPI.putUpdateUserInvalidPath(path, json);
    }

}
