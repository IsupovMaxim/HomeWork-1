package HomeWork7;

import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositiveNegativeTest {
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
    private static final String reason = "reason";
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
    @Test
    public void testingToken() {
        System.out.println("Полоучене токена");
        Response response = Technique.token(TOKEN_BODY);
        response.then().statusCode(200).log().body();
        String token = response.jsonPath().getString(newToken);
        System.out.println("Получили токен " + token);
    }
    @Test
    public void testingCreateAndChekingBooking(){
        System.out.println("Создание бронирования");
        Response bookingResponse = Technique.creatBooking(BOOKING_BODY);
        bookingResponse.then().statusCode(200).log().body();
        String id = bookingResponse.jsonPath().getString(newBooking);
        System.out.println("Бронирование создано" + id);

        System.out.println("Проверка бронирования");
        Response chekingResponse = Technique.checkingBooking(id);
        chekingResponse.then().statusCode(200).log().body();
    }
    @Test
    public void testingCreateUpdateCheckingBooking(){
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
    @Test
    public void testingCreateChekingDeleteBooking(){
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

        System.out.println("Удаление бронирования");
        Technique.deleteBooking(id, token).then().statusCode(201).log().body();

        System.out.println("Проверка бронирования");
        Response chekingResponse = Technique.checkingBooking(id);
        chekingResponse.then().statusCode(404).log().body();
    }
    @Test
    public void negativeTestingToken(){
        System.out.println("Полоучене токена");
        Response response = Technique.token(negativeTOKEN_BODY);
        response.then().statusCode(200).log().body();
        String token = response.jsonPath().getString(newToken);
        String reason = response.jsonPath().getString("reason");
        assertEquals("Bad credentials", reason);
        System.out.println("Получили токен  = " + token);
    }
    @Test
    public void negativeTestingCreatBooking(){
        System.out.println("Создание бронирования c неверным телом ");
        Response bookingResponse = Technique.creatBooking(NegativeCreatBooking_BODY);
        bookingResponse.then().statusCode(200).log().body();
        String id = bookingResponse.jsonPath().getString(newBooking);
        System.out.println("Бронирование с неверным телом - создано " + id);
    }
    @Test
    public void negativeTestingChekingBooking(){
        System.out.println("Создание бронирования");
        Response bookingResponse = Technique.creatBooking(BOOKING_BODY);
        bookingResponse.then().statusCode(200).log().body();
        String id = bookingResponse.jsonPath().getString(negativeNewBooking);
        System.out.println("Бронирование создано" + id);

        System.out.println("Проверка бронирования c неверным id");
        Response chekingResponse = Technique.checkingBooking(id);
        chekingResponse.then().statusCode(404).log().body();
    }
    @Test
    public void negativeTestingDeleteBooking(){
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