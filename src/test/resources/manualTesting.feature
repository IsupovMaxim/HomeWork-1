@authorization
Feature: авторизация на Yandex

  Background: находимся на странице авторизации
    Given Открываем сайт "https://passport.yandex.ru/auth?origin=market_desktop_header"

  @successful
  Scenario Outline: успешная авторизация
    When Вводим верный логин "<username>" и пароль "<password>"
    Then при успешной авторизации происходит переход на страницу "https://id.yandex.ru"
#    в реализации прописываем выход из аккаунта, для запуска следующего теста

    Examples:
      | username                    | password       |
      | YandexTesting2023           | !Test123456789 |
      | yandextesting2023           | !Test123456789 |
      | YandexTesting2023@yandex.ru | !Test123456789 |
      | yandextesting2023@yandex.ru | !Test123456789 |
      | YandexTesting2023@ya.ru     | !Test123456789 |
      | yandextesting2023@ya.ru     | !Test123456789 |

  @fail
  Scenario Outline: авториация с неккоректным логином
    When вводим некоректный логин "<invalidUsername>"
    Then получаем "<error>"

    Examples:
      | invalidUsername                         | error                               |
      |                                         | "логин не указан"                   |
      | 123                                     | "такой логин не подойдет"           |
      | YandexTesting                           | "логин введен некоретно или удален" |
      | яндексТест                              | "такой логин не подойдет"           |
      | qwertyyyyyyyyyyyyyyyyyyyqwertyyyyyyyyyy | "такой логин не подойдет"           |
      | YandexTesting@яндекс.ру                 | "такой логин не подойдет"           |
      | !yandextesting                          | "такой логин не подойдет"           |
      | yandex testing                          | "такой логин не подойдет"           |

  @fail
  Scenario Outline: авторизация с некоректным паролем
    When вводим верный логин "<username>"
    When вводим неккоректный пароль"<invalidPassword>"
    Then получаем "<error>"

    Examples:
      | username          | invalidPassword | error              |
      | YandexTesting2023 |                 | "Пароль не указан" |
      | YandexTesting2023 | 123             | "Неверный пароль"  |