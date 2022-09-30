package starter.Reqres.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;

public class DeleteUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
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
//Scenario2
    @Given("Delete user with invalid id {int}")
    public void deleteUserWithInvalidIdId(int id) {
        reqresAPI.deleteUser(id);
    }
    //Scenario3
    @Given("Delete user invalid id with character {string}")
    public void deleteUserInvalidIdWithCharacter(String id) {
        reqresAPI.deleteUserIdString(id);
    }
    //Scenario4
    @Given("Delete user invalid id with special character {string}")
    public void deleteUserInvalidIdWithSpecialCharacter(String id) {
        reqresAPI.deleteUserIdString(id);
    }
    //Scenario5
    @Given("Delete user invalid path with character {string}")
    public void deleteUserInvalidPathWithCharacter(String path) {
        reqresAPI.deleteUserInvalidPath(path);
    }

    @When("Send request delete user invalid path")
    public void sendRequestDeleteUserInvalidPath() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER_INVALID_PATH);
    }
    //Scenario6
    @Given("Delete user invalid path special character {string}")
    public void deleteUserInvalidPathSpecialCharacter(String path) {
        reqresAPI.deleteUserInvalidPath(path);
    }


}
