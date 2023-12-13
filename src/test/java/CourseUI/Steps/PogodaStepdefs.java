package CourseUI.Steps;

import CourseUI.Page.Meaning;;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PogodaStepdefs {
    Meaning meaning = new Meaning();

    @Given("^входим на стрицу \"([^\"]*)\"$")
    public void openWebsite(String url) {
        Selenide.open(url);
    }

    @When("^выбираем город \"([^\"]*)\"$")
    public void chooseСity(String city) {
        meaning.entryField.setValue(city).pressEnter();
        meaning.cityBotton.click();
        meaning.fieldCity.click();
    }

    @Then("^получаем прогноз погоды на заданное кол-во дней - \"([^\"]*)\"$")
    public void getЕheWeatherForecast(Integer day) {
        for (int i = 0; i < day; i++){

            System.out.println(meaning.numberData.get(i).text());
            System.out.println(" ");
            System.out.println(meaning.morning.get(i).text());
            System.out.println(meaning.days.get(i).text());
            System.out.println(meaning.yesterday.get(i).text());
            System.out.println(meaning.night.get(i).text());
            System.out.println(" ");
        }
    }
}