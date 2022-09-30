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

public class PostLoginStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post login with all valid value")
    public void postLoginWithAllValidValue() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostLogin.json");
        reqresAPI.postLogin(json);
    }

    @When("Send request post login")
    public void sendRequestPostLogin() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }

    @And("Response body should contain token {string}")
    public void responseBodyShouldContainToken(String token) {
        SerenityRest.then().body(ReqresResponses.TOKEN,equalTo(token));
    }
    @And("Post login valid value json schema validator")
    public void postLoginValidValueJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_VALIDATOR_FILE+"/PostLoginJsonSchemaValidator.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //Scenario1
    @Given("Post login input email empty password")
    public void postLoginInputEmailEmptyPassword() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostLoginEmptyPassword.json");
        reqresAPI.postLogin(json);
    }
    @And("Post login error message json schema validator")
    public void postLoginErrorMessageJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_VALIDATOR_FILE+"/PostLoginErrorMessageJsonSchemaValidator.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //Scenario2
    @Given("Post login input password empty email")
    public void postLoginInputPasswordEmptyEmail() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostLoginEmptyEmail.json");
        reqresAPI.postLogin(json);
    }
    //Scenario3
    @Given("Post login empty email empty passoword")
    public void postLoginEmptyEmailEmptyPassoword() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostLoginEmptyAllValue.json");
        reqresAPI.postLogin(json);
    }
    //Scenario4
    @Given("Post login input unregistered email and password")
    public void postLoginInputUnregisteredEmailAndPassword() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostLoginUnregisteredEmail.json");
        reqresAPI.postLogin(json);
    }
}
