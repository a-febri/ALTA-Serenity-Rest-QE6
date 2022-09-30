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

public class PostRegisterStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Post register with all valid body request")
    public void postRegisterWithAllValidBodyRequest() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostRegister.json");
        reqresAPI.postRegister(json);
    }

    @When("Send request post register")
    public void sendRequestPostRegister() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER);
    }

    @And("Response body should contains id {int} and token {string}")
    public void responseBodyShouldContainsIdAndToken(int id, String token) {
        SerenityRest.then().body(ReqresResponses.ID_POST_REGISTER,equalTo(id))
                .body(ReqresResponses.TOKEN,equalTo(token));
    }
    @And("Post register with valid value json schema validator")
    public void postRegisterWithValidValueJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_VALIDATOR_FILE+"/PostRegisterValidValueJsonSchemaValidator.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //Scenario2
    @Given("Post register input email empty password")
    public void postRegisterInputEmailEmptyPassword() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostRegisterEmptyPassword.json");
        reqresAPI.postRegister(json);
    }

    @And("Response body should contain error message {string}")
    public void responseBodyShouldContainErrorMessage(String errorMessage) {
        SerenityRest.then().body(ReqresResponses.ERROR_MESSAGE,equalTo(errorMessage));
    }
    @And("Post register error message json validator")
    public void postRegisterErrorMessageJsonValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_VALIDATOR_FILE+"/PostRegisterErrorMessageJsonSchemaValidator.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //Scenario3
    @Given("Post register input password empty email")
    public void postRegisterInputPasswordEmptyEmail() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostRegisterEmptyEmail.json");
        reqresAPI.postRegister(json);
    }
    //Scenario4
    @Given("Post register empty email empty password")
    public void postRegisterEmptyEmailEmptyPassword() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostRegisterEmptyAllvalue.json");
        reqresAPI.postRegister(json);
    }
}
