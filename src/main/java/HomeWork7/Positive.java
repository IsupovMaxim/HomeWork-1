package HomeWork7;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;


public class Positive {
    private static final String BOOKING_URL = "https://restful-booker.herokuapp.com";

    public static Response token(String TOKEN_BODY) {
        return RestAssured.given()
                .baseUri(BOOKING_URL)
                .body(TOKEN_BODY)
                .contentType(ContentType.JSON)
                .post(BOOKING_URL + "/auth");
    }

    public static Response creatBooking(String BOOKING_BODY) {
        return RestAssured.given()
                .baseUri(BOOKING_URL)
                .body(BOOKING_BODY)
                .contentType(ContentType.JSON)
                .post("/booking");
    }

    public static Response checkingBooking(String bookingid) {
        return RestAssured.given()
                .baseUri(BOOKING_URL)
                .get("/booking/" + bookingid);
    }

    public static Response updateBooking(String id, String token, String UpdateBooking_BODY ) {
        return RestAssured.given()
                .baseUri(BOOKING_URL)
                .header("cookie", "token=" + token)
                .contentType(ContentType.JSON)
                .body(UpdateBooking_BODY)
                .put("/booking/" + id);
    }

    public static Response deleteBooking(String bookingid, String token) {
        return RestAssured.given()
                .baseUri(BOOKING_URL)
                .header("cookie", "token=" + token)
                .delete("/booking/" + bookingid);
    }
}

//        Response response = given()
//                .baseUri("https://restful-booker.herokuapp.com")
//                .body("{\n" +
//                        "  \"firstname\": \"Максим\"," +
//                        "  \"lastname\": \"Исупов\"," +
//                        "  \"totalprice\": 2500," +
//                        "  \"depositpaid\": true," +
//                        "  \"bookingdates\": {" +
//                        "    \"checkin\": \"2023-08-01\"," +
//                        "    \"checkout\": \"2023-08-10\"" +
//                        "  },\n" +
//                        "  \"additionalneeds\": \"Breakfest\"" +
//                        "}")
//                .contentType(ContentType.JSON)
//                .post("/booking")
//                .then()
//                .statusCode(200)
//                .log()
//                .body()
//                .extract()
//                .response();
//
//        bookingid = response.jsonPath().getInt("bookingid");
//
//        System.out.println("bookingid " + bookingid);
//    }
//
//   public static void checkingBooking() {
//       given()
//             .baseUri("BOOKING_URL")
//                .contentType(ContentType.JSON)
//                .get("/booking/" + bookingid)
//                .then()
//                .statusCode(200)
//                .log()
//                .body();
//
//        System.out.println("Бронирование создано");
//    }
//
//    public static void updateBooking() {
//        given()
//                .baseUri("https://restful-booker.herokuapp.com")
//                .header("cookie", "token=" + token)
//                .contentType(ContentType.JSON)
//                .body("{\n" +
//                        "  \"firstname\": \"Максим\"," +
//                        "  \"lastname\": \"Исупов\"," +
//                        "  \"totalprice\": 2500," +
//                        "  \"depositpaid\": true," +
//                        "  \"bookingdates\": {" +
//                        "    \"checkin\": \"2023-08-01\"," +
//                        "    \"checkout\": \"2023-08-05\"" +
//                        "  },\n" +
//                        "  \"additionalneeds\": \"Breakfest\"" +
//                        "}")
//                .log()
//                .body()
//                .put("/booking/" + bookingid)
//                .then()
//                .statusCode(200)
//                .log()
//                .body();
//
//        System.out.println("bookingid " + bookingid);
//    }
//
//    public static void deleteBooking() {
//        given()
//                .baseUri("https://restful-booker.herokuapp.com")
//                .header("cookie", "token=" + token)
//                .delete("/booking/" + bookingid)
//                .then()
//                .statusCode(201);
//
//        System.out.println("Бронирование " + bookingid + " успешно удалено");
//    }
//
//    public static void checkingDeleteBooking() {
//        given()
//                .baseUri("https://restful-booker.herokuapp.com")
//                .contentType(ContentType.JSON)
//                .get("/booking/" + bookingid)
//                .then()
//                .statusCode(404)
//                .log()
//                .body();
//
//        System.out.println("Бронирование удалено");
//    }
