package HomeWork9;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class HerokuappSteps {
    static SelenideElement Password = $x("//*[@id=\"password\"]");
    static SelenideElement Login = $x("//*[@id=\"login\"]/button");
    static SelenideElement LogOut = $x("//*[@id=\"content\"]/div/a/i");
    static SelenideElement FailLogOut = $x("//*[@id=\"flash\"]");
    static SelenideElement UserName = $x("//*[@id=\"username\"]");
    static SelenideElement checkBoxes = $x("//input[@type='checkbox'][1]");
    public static final String URL = "http://the-internet.herokuapp.com/hovers";
    SelenideElement user1 = $x("//*[@id=\"content\"]/div/div[1]/img");
    SelenideElement text = $x("//*[@id=\"content\"]/div/div[1]/div/h5");
    SelenideElement start = $x("//*[@id=\"start\"]/button");
    SelenideElement text1 = $x("//*[@id=\"finish\"]/h4");
    SelenideElement field = $x("//*[@id=\"target\"]");
    SelenideElement ALT = $x("//*[@id=\"result\"]");
    public static String text2 = "q";

    @Given("^открыть сайт \"([^\"]*)\"$")
    public void openWebSite(String url) {
        Selenide.open(url);
    }

    @And("^нажать кнопку checkBoxes$")
    public void clickFirstButton() {
        checkBoxes.click();
    }

    @When("^проверить нажатали первая кнопка$")
    public void chekingClickFirstButton() {
        checkBoxes.shouldBe(Condition.selected);
    }


    @Given("^перейти на сайт \"([^\"]*)\"$")
    public void goToWebsite(String url) {
        Selenide.open(url);
    }

    @And("^вводим логин$")
    public void enterLogin() {
        UserName.setValue("tomsmith");
    }

    @And("^вводим пароль$")
    public void enterPassword() {
        Password.setValue("SuperSecretPassword!");
    }

    @And("^нажать кнопку Login$")
    public void ClickTheLoginButton() {
        Login.click();
    }

    @When("^проверить результат$")
    public void checkResult() {
        LogOut.shouldBe(Condition.exist);
        System.out.println("Успешная авторизация");
    }

    @And("^вводим неверный логин$")
    public void enterInvalidLogin() {
        UserName.setValue("tomsmith1");
    }

    @When("^проверить неуспешный результат$")
    public void checkUnsuccessfulResult() {
        FailLogOut.shouldBe(Condition.exist);

        System.out.println("Авторизация провалена");
    }

    @Given("^перейти по сcылке \"([^\"]*)\"$")
    public void followTheLink(String url) {
        Selenide.open(url);
    }

    @And("^навести на нужного пользователя$")
    public void pointToTheDesiredUser() {
        user1.hover();
    }

    @When("^проверить, что отображается текст$")
    public void checkWhatTextDisplayed() {
        text.shouldNotBe(Condition.checked);
        System.out.println("Успешная проверка ");
    }

    @Given("^открыть сайт  \"([^\"]*)\"$")
    public void openWebSiteDynamicallyLoadedPage(String url) {
        Selenide.open(url);
    }

    @And("^нажать кнопку Start$")
    public void clickButtonStart() {
        start.click();
    }

    @When("^получить результат$")
    public void geеtTheResult() {
        Configuration.timeout = 10000;
        text1.shouldHave(Condition.visible);

        System.out.println("Проверка завершена");
    }

    @Given("^пройти на ресурс \"([^\"]*)\"$")
    public void goToResource(String url) {
        Selenide.open(url);
    }

    @And("^нажать на поле ввода$")
    public void ClickInputFieldAndEnterText() {
        field.click();

    }

    @And("^ввести текст$")
    public void enterText() {
        actions().sendKeys(text2).perform();
    }

    @When("^должны получить You entered: q$")
    public void mustGet() {
        ALT.shouldHave(Condition.text("You entered: q"));

        System.out.println("Проверка завершена");
    }
}