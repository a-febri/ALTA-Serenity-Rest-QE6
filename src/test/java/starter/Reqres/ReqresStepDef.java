package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;


public class ReqresStepDef {
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
//scenario2
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
//Scenario3
    @Given("Get list user with invalid parameter page {string}")
    public void getListUserWithInvalidParameterPage(String page) {
        reqresAPI.getListUsersInvalidPage(page);
    }
    @Then("Should return {int} not found")
    public void shouldReturnNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

//Scenario4
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
//Scenario7
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
//Scenario8
    @Given("Get list resource with invalid path {string}")
    public void getListResourceWithInvalidPath(String path) {
        reqresAPI.getListResource(path);
    }
//Scenario9
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


//Scenario10
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
//Scenario11
    @Given("Get single resource with id {string}")
    public void getSingleResourceWithId(String id) {
        reqresAPI.getSingleResources(id);
    }

//Scenario12
    @Given("Post create new user input job empty name")
    public void postCreateNewUserInputJobEmptyName() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostCreateNewUserEmptyName.json");
        reqresAPI.postCreateNewUser(json);
    }

    @Then("Should return {int} bad request")
    public void shouldReturnBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);

    }

//Scenario12
    @Given("Post create new user input name empty job")
    public void postCreateNewUserInputNameEmptyJob() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostCreateNewUserEmptyJob.json");
        reqresAPI.postCreateNewUser(json);
    }
//Scenario13
    @Given("Post create new user empty name and job")
    public void postCreateNewUserEmptyNameAndJob() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostCreateNewUserEmptyAllValue.json");
        reqresAPI.postCreateNewUser(json);
    }
//Scenario14
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
//Scenario15
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
//Scenario16
    @Given("Post register input password empty email")
    public void postRegisterInputPasswordEmptyEmail() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostRegisterEmptyEmail.json");
        reqresAPI.postRegister(json);
    }
//Scenario17
    @Given("Post register empty email empty password")
    public void postRegisterEmptyEmailEmptyPassword() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostRegisterEmptyAllvalue.json");
        reqresAPI.postRegister(json);
    }
//Scenario18
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
//Scenario19
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
//Scenario20
    @Given("Post login input password empty email")
    public void postLoginInputPasswordEmptyEmail() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostLoginEmptyEmail.json");
        reqresAPI.postLogin(json);
    }
//Scenario21
    @Given("Post login empty email empty passoword")
    public void postLoginEmptyEmailEmptyPassoword() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostLoginEmptyAllValue.json");
        reqresAPI.postLogin(json);
    }
//Scenario22
    @Given("Post login input unregistered email and password")
    public void postLoginInputUnregisteredEmailAndPassword() {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PostLoginUnregisteredEmail.json");
        reqresAPI.postLogin(json);
    }
//Scenario23
    @Given("put update user with id {int}")
    public void putUpdateUserWithIdId(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PutUpdateUser.json");
        reqresAPI.putUpdateUser(id, json);
    }
    @And("Put update user json schema validator")
    public void putUpdateUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_VALIDATOR_FILE+"/PutUpdateUserJsonSchemaValidator.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }
//Scenario24
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Should return {int} no content")
    public void shouldReturnNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }
//Scenario25
    @Given("Put update user with id {int} only input name")
    public void putUpdateUserWithIdIdOnlyInputName(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PutUpdateUserEmptyName.json");
        reqresAPI.putUpdateUser(id, json);
    }
//Scenario26
    @Given("Put update user with id {int} only input job")
    public void putUpdateUserWithIdIdOnlyInputJob(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PutUpdateUserEmptyJob.json");
        reqresAPI.putUpdateUser(id, json);
    }
//Scenario27
    @Given("Put update user with id {int} empty name empty job")
    public void putUpdateUserWithIdEmptyNameEmptyJob(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PutUpdateUserEmptyAllValue.json");
        reqresAPI.putUpdateUser(id, json);
    }
//Scenario28
    @Given("Put update user with invalid path {string} valid json")
    public void putUpdateUserWithInvalidPathEmptyNameEmptyJob(String path) {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PutUpdateUser.json");
        reqresAPI.putUpdateUserInvalidPath(path, json);
    }

    @When("Send request put update user invalid path")
    public void sendRequestPutUpdateUserInvalidPath() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER_INVALID_PATH);
    }

//Scenario29
    @Given("Put update user with invalid path {string} with special char valid json")
    public void putUpdateUserWithInvalidPathWithSpecialCharValidJson(String path) {
        File json = new File(ReqresAPI.JSON_REQUEST_BODY_FILE +"/PutUpdateUser.json");
        reqresAPI.putUpdateUserInvalidPath(path, json);
    }
//Scenario30
    @Given("Delete user invalid id with character {string}")
    public void deleteUserInvalidIdWithCharacter(String id) {
        reqresAPI.deleteUserIdString(id);
    }
//Scenario31
    @Given("Delete user invalid path with character {string}")
    public void deleteUserInvalidPathWithCharacter(String path) {
        reqresAPI.deleteUserInvalidPath(path);
    }

    @When("Send request delete user invalid path")
    public void sendRequestDeleteUserInvalidPath() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER_INVALID_PATH);
    }
//Scenario32
    @Given("Get delayed response with valid parameter delay {int}")
    public void getDelayedResponseWithValidParameterDelay(int delay) {
        reqresAPI.getDelayedResponse(delay);
    }

    @When("Send request to get delayed response")
    public void sendRequestToGetDelayedResponse() throws InterruptedException {
        Thread.sleep(3000);
        SerenityRest.when().get(ReqresAPI.GET_DELAYED_RESPONSE);
    }

    @And("Get delayed response json schema validator")
    public void getDelayedResponseJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_VALIDATOR_FILE+"/GetDelayedResponseJsonSchemaValidator.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
