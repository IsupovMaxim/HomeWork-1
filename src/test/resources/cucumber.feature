Feature:  RestAssured/Selenide

  Scenario: Успешная авторизация на сайте
    Given отправляю запрос с верным логином и паролем "https://restful-booker.herokuapp.com/auth"
    When проверяю полученный запрос

  Scenario: Создание брони на сайте
    Given отправляем запрос на создание брони "https://restful-booker.herokuapp.com/booking"
    When проверяем запрос

  Scenario: Внесения изменений в бронирование
    Given отправляем запрос на изменение в бронировании "https://restful-booker.herokuapp.com/booking/bookingid"
    When проверяем запрос на изменение

  Scenario: Удаление бронирования
    Given отправляем запрос на удаление бронирования "https://restful-booker.herokuapp.com/booking/bookingid"
    When проверяем запрос на удаление

  Scenario: Неуспешная вторизация на сайте
    Given отправлям запрос с неверным логином и поролем "https://restful-booker.herokuapp.com/auth"
    When проверяем неуспешный запрос

  Scenario: Неудачное создание брони на сайте
    Given отправляем запрос неверными данными на создание брони "https://restful-booker.herokuapp.com/booking"
    When проверяем запрос с неверными данными

  Scenario: Неудачное внесение изменений в бронирование
    Given отправляем запрос с неверным id брони "https://restful-booker.herokuapp.com/booking/bookingid"
    When проверяем запрос с неверным id брони

  Scenario: Неудачное удаление
    Given отправляем запрос на удаление с неверным id "https://restful-booker.herokuapp.com/booking/bookingid"
    When проверяем запрос на удаление с неверным id

  Scenario: Нажать чекбокс, проверить, что нажата
    Given открыть сайт "https://the-internet.herokuapp.com/checkboxes"
    And нажать кнопку checkBoxes
    When проверить нажатали первая кнопка

  Scenario:Успешная авторизация Form Authentication
    Given перейти на сайт "http://the-internet.herokuapp.com/login"
    And вводим логин
    And вводим пароль
    And нажать кнопку Login
    When проверить результат

  Scenario: Неуспешная авторизация Form Authentication
    Given перейти на сайт "http://the-internet.herokuapp.com/login"
    And вводим неверный логин
    And вводим пароль
    And нажать кнопку Login
    When проверить неуспешный результат

  Scenario:Навести на нужного пользователя, проверить что отображается текст(Hovers)
    Given перейти по сcылке "http://the-internet.herokuapp.com/hovers"
    And навести на нужного пользователя
    When проверить, что отображается текст

  Scenario: Dynamically Loaded Page Elements(второй пример, дождать текста после лоадера)
    Given открыть сайт  "https://the-internet.herokuapp.com/dynamic_loading/2"
    And нажать кнопку Start
    When получить результат

  Scenario:Key Presses(отправить клавишу, проверить)
    Given пройти на ресурс "https://the-internet.herokuapp.com/key_presses"
    And нажать на поле ввода
    And ввести текст
    When должны получить You entered: q