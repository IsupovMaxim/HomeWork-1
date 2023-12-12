package HomeWork9;

import HomeWork7.Technique;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertEquals;

public class BookingSteps {
    private static final String negativeTOKEN_BODY = "{ \"username\" : \"amin\"," +
            "\"password\" : \"password13\" }";
    private static final String TOKEN_BODY = "{ \"username\" : \"admin\"," +
            "\"password\" : \"password123\" }";
    private static final String BOOKING_BODY = "{\n" +
            "  \"firstname\": \"Максим\"," +
            "  \"lastname\": \"Исупов\"," +
            "  \"totalprice\": 2500," +
            "  \"depositpaid\": true," +
            "  \"bookingdates\": {" +
            "    \"checkin\": \"2023-08-01\"," +
            "    \"checkout\": \"2023-08-10\"" +
            "  },\n" +
            "  \"additionalneeds\": \"Breakfest\"" +
            "}";
    private static final String newToken = "token";
    private static final String newBooking = "bookingid";
    private static final String negativeNewBooking = "qwerty";
    private static final String UpdateBooking_BODY = "{\n" +
            "  \"firstname\": \"Максим\"," +
            "  \"lastname\": \"Исупов\"," +
            "  \"totalprice\": 2500," +
            "  \"depositpaid\": true," +
            "  \"bookingdates\": {" +
            "    \"checkin\": \"2023-08-01\"," +
            "    \"checkout\": \"2023-08-05\"" +
            "  },\n" +
            "  \"additionalneeds\": \"Breakfest\"" +
            "}";
    private static final String NegativeCreatBooking_BODY = "{\n" +
            "  \"firstname\": \"Максим\"," +
            "  \"lastname\": \"Исупов\"," +
            "  \"totalprice\": 2500," +
            "  \"depositpaid\": true," +
            "  \"bookingdates\": {" +
            "    \"checkin\": \"2024-08-01\"," +
            "    \"checkout\": \"2023-08-10\"" +
            "  },\n" +
            "  \"additionalneeds\": \"Breakfest\"" +
            "}";

    @Given("^отправляю запрос с верным логином и паролем \"([^\"]*)\"$")
    public void getToken(String url) {
        RestAssured.given()
                .body(TOKEN_BODY)
                .contentType(ContentType.JSON)
                .post(url);
    }

    @When("^проверяю полученный запрос$")
    public void chekingTheReceivedToken() {
        System.out.println("Полоучене токена");
        Response response = Technique.token(TOKEN_BODY);
        response.then().statusCode(200).log().body();
        String token = response.jsonPath().getString(newToken);
        System.out.println("Получили токен " + token);
    }

    @Given("^отправляем запрос на создание брони \"([^\"]*)\"$")
    public void CreateBooking(String url) {
        RestAssured.given()
                .body(BOOKING_BODY)
                .contentType(ContentType.JSON)
                .post(url);
    }

    @When("^проверяем запрос$")
    public void chekingCreateBooking() {
        System.out.println("Создание бронирования");
        Response bookingResponse = Technique.creatBooking(BOOKING_BODY);
        bookingResponse.then().statusCode(200).log().body();
        String id = bookingResponse.jsonPath().getString(newBooking);
        System.out.println("Бронирование создано " + id);

        System.out.println("Проверка бронирования");
        Response chekingResponse = Technique.checkingBooking(id);
        chekingResponse.then().statusCode(200).log().body();
    }

    @Given("^отправляем запрос на изменение в бронировании \"([^\"]*)\"$")
    public void updateBooking(String url) {
        RestAssured.given()
                .header("cookie", "token=" + newToken)
                .contentType(ContentType.JSON)
                .body(UpdateBooking_BODY)
                .put(url);
    }

    @When("^проверяем запрос на изменение$")
    public void chekingUpdateBooking() {
        System.out.println("Полоучене токена");
        Response response = Technique.token(TOKEN_BODY);
        response.then().statusCode(200).log().body();
        String token = response.jsonPath().getString(newToken);
        System.out.println("Получили токен " + token);

        System.out.println("Создание бронирования");
        Response bookingResponse = Technique.creatBooking(BOOKING_BODY);
        bookingResponse.then().statusCode(200).log().body();
        String id = bookingResponse.jsonPath().getString(newBooking);
        System.out.println("Бронирование создано" + id);

        System.out.println("Обнавление бронирования");
        Technique.updateBooking(id, token, UpdateBooking_BODY).then().statusCode(200).log().body();

        System.out.println("Проверка бронирования");
        Response chekingResponse = Technique.checkingBooking(id);
        chekingResponse.then().statusCode(200).log().body();
    }

    @Given("^отправляем запрос на удаление бронирования \"([^\"]*)\"$")
    public void deletedBooking(String url) {
        RestAssured.given()
                .header("cookie", "token=" + newToken)
                .delete(url);
    }

    @When("^проверяем запрос на удаление$")
    public void ChekingDeleteBooking() {
        System.out.println("Полоучене токена");
        Response response = Technique.token(TOKEN_BODY);
        response.then().statusCode(200).log().body();
        String token = response.jsonPath().getString(newToken);
        System.out.println("Получили токен " + token);

        System.out.println("Создание бронирования");
        Response bookingResponse = Technique.creatBooking(BOOKING_BODY);
        bookingResponse.then().statusCode(200).log().body();
        String id = bookingResponse.jsonPath().getString(newBooking);
        System.out.println("Бронирование создано " + id);

        System.out.println("Удаление бронирования");
        Technique.deleteBooking(id, token).then().statusCode(201).log().body();

        System.out.println("Проверка бронирования");
        Response chekingResponse = Technique.checkingBooking(id);
        chekingResponse.then().statusCode(404).log().body();
    }

    @Given("^отправлям запрос с неверным логином и поролем \"([^\"]*)\"$")
    public void negativeGetBooking(String url) {
        RestAssured.given()
                .body(negativeTOKEN_BODY)
                .contentType(ContentType.JSON)
                .post(url);
    }

    @When("^проверяем неуспешный запрос$")
    public void chekingNegativeGetTooking() {
        System.out.println("Полоучене токена");
        Response response = Technique.token(negativeTOKEN_BODY);
        response.then().statusCode(200).log().body();
        String token = response.jsonPath().getString(newToken);
        String reason = response.jsonPath().getString("reason");
        assertEquals("Bad credentials", reason);
        System.out.println("Получили токен  = " + token);
    }

    @Given("^отправляем запрос неверными данными на создание брони \"([^\"]*)\"$")
    public void negativeCreateBooking(String url) {
        RestAssured.given()
                .body(NegativeCreatBooking_BODY)
                .contentType(ContentType.JSON)
                .post(url);
    }

    @When("^проверяем запрос с неверными данными$")
    public void chekingNegativeCreateBooking() {
        System.out.println("Создание бронирования c неверным телом ");
        Response bookingResponse = Technique.creatBooking(NegativeCreatBooking_BODY);
        bookingResponse.then().statusCode(200).log().body();
        String id = bookingResponse.jsonPath().getString(newBooking);
        System.out.println("Бронирование с неверным телом - создано " + id);
    }

    @Given("^отправляем запрос с неверным id брони \"([^\"]*)\"$")
    public void negativeCreateBookingid(String url) {
        RestAssured.given()
                .header("cookie", "token=" + newToken)
                .contentType(ContentType.JSON)
                .body(UpdateBooking_BODY)
                .put(url);
    }

    @When("^проверяем запрос с неверным id брони$")
    public void chekingNegativeCreataBookingid() {
        System.out.println("Создание бронирования");
        Response bookingResponse = Technique.creatBooking(BOOKING_BODY);
        bookingResponse.then().statusCode(200).log().body();
        String id = bookingResponse.jsonPath().getString(negativeNewBooking);
        System.out.println("Бронирование создано " + id);

        System.out.println("Проверка бронирования c неверным id");
        Response chekingResponse = Technique.checkingBooking(id);
        chekingResponse.then().statusCode(404).log().body();
    }

    @Given("^отправляем запрос на удаление с неверным id \"([^\"]*)\"$")
    public void NegativeDeleteBooking(String url) {
            RestAssured.given()
                    .header("cookie", "token=" + newToken)
                    .delete(url);
    }

    @When("^проверяем запрос на удаление с неверным id$")
    public void chekingNegativeDeleteBooking() {
        System.out.println("Полоучене токена");
        Response response = Technique.token(TOKEN_BODY);
        response.then().statusCode(200).log().body();
        String token = response.jsonPath().getString(newToken);
        System.out.println("Получили токен " + token);

        System.out.println("Создание бронирования");
        Response bookingResponse = Technique.creatBooking(BOOKING_BODY);
        bookingResponse.then().statusCode(200).log().body();
        String id = bookingResponse.jsonPath().getString(negativeNewBooking);
        System.out.println("Бронирование создано" + id);

        System.out.println("Удаление бронирования с неверным id");
        Technique.deleteBooking(id, token).then().statusCode(405).log().body();
    }
}