Feature:YandexPogoda

  Background: находимся на странице
    Given входим на стрицу "https://yandex.ru/pogoda"

    Scenario: прогноз погоды на "n <= 10" количество дней
      When выбираем город "Ижевск"
      Then получаем прогноз погоды на заданное кол-во дней - "7"