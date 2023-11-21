package HomeWork7;

import HomeWork7.Positive;
import io.restassured.response.Response;
import org.junit.Test;

public class PositiveTest {
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

    @Test
    public void testingToken() {
        System.out.println("Полоучене токена");
        Response response = Positive.token(TOKEN_BODY);
        response.then().statusCode(200).log().body();
        String token = response.jsonPath().getString(newToken);
        System.out.println("Получили токен " + token);
    }
    @Test
    public void testingCreateAndChekingBooking(){
        System.out.println("Создание бронирования");
        Response bookingResponse = Positive.creatBooking(BOOKING_BODY);
        bookingResponse.then().statusCode(200).log().body();
        String id = bookingResponse.jsonPath().getString(newBooking);
        System.out.println("Бронирование создано" + id);

        System.out.println("Проверка бронирования");
        Response chekingResponse = Positive.checkingBooking(id);
        chekingResponse.then().statusCode(200).log().body();
    }
    @Test
    public void testingCreateUpdateCheckingBooking(){
        System.out.println("Полоучене токена");
        Response response = Positive.token(TOKEN_BODY);
        response.then().statusCode(200).log().body();
        String token = response.jsonPath().getString(newToken);
        System.out.println("Получили токен " + token);

        System.out.println("Создание бронирования");
        Response bookingResponse = Positive.creatBooking(BOOKING_BODY);
        bookingResponse.then().statusCode(200).log().body();
        String id = bookingResponse.jsonPath().getString(newBooking);
        System.out.println("Бронирование создано" + id);

        System.out.println("Обнавление бронирования");
        Positive.updateBooking(id, token, UpdateBooking_BODY).then().statusCode(200).log().body();

        System.out.println("Проверка бронирования");
        Response chekingResponse = Positive.checkingBooking(id);
        chekingResponse.then().statusCode(200).log().body();
    }
    @Test
    public void testingCreateChekingDeleteBooking(){
        System.out.println("Полоучене токена");
        Response response = Positive.token(TOKEN_BODY);
        response.then().statusCode(200).log().body();
        String token = response.jsonPath().getString(newToken);
        System.out.println("Получили токен " + token);

        System.out.println("Создание бронирования");
        Response bookingResponse = Positive.creatBooking(BOOKING_BODY);
        bookingResponse.then().statusCode(200).log().body();
        String id = bookingResponse.jsonPath().getString(newBooking);
        System.out.println("Бронирование создано" + id);

        System.out.println("Удаление бронирования");
        Positive.deleteBooking(id, token).then().statusCode(201).log().body();

        System.out.println("Проверка бронирования");
        Response chekingResponse = Positive.checkingBooking(id);
        chekingResponse.then().statusCode(404).log().body();
    }
}