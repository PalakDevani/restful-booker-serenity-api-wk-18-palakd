package com.restful.booker.restfulinfo;

import com.restful.booker.constants.EndPoints;
import com.restful.booker.model.BookingPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class BookingSteps {

    @Step("Create user with firstName:{0},lastName:{1},totalPrice:{2},depositPaid:{3},bookingDates:{4},additionalNeeds:{5}")
    public ValidatableResponse createUser(String firstName, String lastName, int totalPrice, boolean depositPaid, HashMap<String, String> bookingDates, String additionalNeeds) {
        HashMap<String, String> dates = new HashMap<>();
        dates.put("checkin", "2023-01-01");
        dates.put("checkout", "2023-02-02");

//HashMap<String,String> bookingDates
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname(firstName);
        bookingPojo.setLastname(lastName);
        bookingPojo.setTotalprice(totalPrice);
        bookingPojo.setDepositpaid(depositPaid);
        bookingPojo.setBookingdates(bookingDates);
        bookingPojo.setAdditionalneeds(additionalNeeds);

        return SerenityRest.given().log().all()
                .headers("Content-Type", "application/json")
                .body(bookingPojo)
                .when()
                .post(EndPoints.CREATE_BOOKING)
                .then();

    }

    @Step("This method will get booking with firsname:{0},token:{1}")
    public HashMap<String, Object> getBookindByFirstName(String firstName, String token) {
        String s1 = "findAll{it.firstname=='";
        String s2 = "'}.get(0)";
        return SerenityRest.given().log().all()
                .headers("Cookie", "token=" + token)
                .when()
                .get(EndPoints.GET_ALL_BOOKING)
                .then()
                .statusCode(200)
                .extract()
                .path(s1 + firstName + s2);

    }

    @Step("This method will get booking with bookingId:{0},token:{1}")
    public ValidatableResponse getBookingByID(int bookingId, String token) {
        return SerenityRest.given().log().all()
                .pathParams("bookingId", bookingId)
                .header("Accept", "application/json")
                .headers("Content-Type", "application/json")
                .headers("Cookie", "token=" + token)
                .when()
                .get(EndPoints.GET_BOOKING_WITH_ID)
                .then();


    }

    @Step("This method will update booking with BookingId:{0} firstName:{1},lastName:{2},totalPrice:{3},depositPaid:{4},bookingDates:{5},additionalNeeds:{6}")
    public ValidatableResponse updateBookingById(int bookingId, String firstName, String lastName, int totalPrice, boolean depositPaid, HashMap<String, String> bookingDates, String additionalNeeds, String token) {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname(firstName);
        bookingPojo.setLastname(lastName);
        bookingPojo.setTotalprice(totalPrice);
        bookingPojo.setDepositpaid(depositPaid);
        bookingPojo.setBookingdates(bookingDates);
        bookingPojo.setAdditionalneeds(additionalNeeds);
        return SerenityRest.given().log().all()
                .pathParams("bookingId", bookingId)
                .headers("Cookie", "token=" + token)
                .header("Accept", "application/json")
                .headers("Content-Type", "application/json")
                .body(bookingPojo)
                .when()
                .put(EndPoints.UPDATE_BOOKING_WITH_ID)
                .then();

    }

    @Step("This method will delete booking with bookingId:{0}")
    public ValidatableResponse deleteBooking(int bookingId, String token) {
        return SerenityRest.given().log().all()
                .pathParams("bookingId", bookingId)
                .headers("Content-Type", "application/json")
                .headers("Cookie", "token=" + token)
                .when()
                .delete(EndPoints.DELETE_BOOKING_WITH_ID)
                .then();
    }

    @Step("This method will get booking with bookingId:{0},token:{1}")
    public ValidatableResponse getBooking(int bookingId, String token) {
        return SerenityRest.given().log().all()
                .pathParams("bookingId", bookingId)
                .header("Accept", "application/json")
                .headers("Content-Type", "application/json")
                .headers("Cookie", "token=" + token)
                .when()
                .get(EndPoints.GET_BOOKING_WITH_ID)
                .then();
    }
}
