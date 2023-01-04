package com.restful.booker.restfulinfo;

import com.restful.booker.constants.EndPoints;
import com.restful.booker.model.AuthPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class AuthSteps {

    @Step("This method will generate token username:{0},password:{1}")
    public ValidatableResponse getToken(String userName, String password) {
        AuthPojo authPojo = new AuthPojo();
        authPojo.setUsername(userName);
        authPojo.setPassword(password);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(authPojo)
                .when()
                .post(EndPoints.AUTH)
                .then()
                .log().all();
    }

}
