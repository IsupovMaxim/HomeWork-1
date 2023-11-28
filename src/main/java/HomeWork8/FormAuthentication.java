package HomeWork8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$x;

public class FormAuthentication {
    public static final String LoginPage_URL = "http://the-internet.herokuapp.com/login";
    static SelenideElement UserName = $x("//*[@id=\"username\"]");
    static SelenideElement Password = $x("//*[@id=\"password\"]");
    static SelenideElement Login = $x("//*[@id=\"login\"]/button");
    static SelenideElement LogOut = $x("//*[@id=\"content\"]/div/a/i");
    static SelenideElement FailLogOut = $x("//*[@id=\"flash\"]");

    @Test
    public void positiveAuthorization() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\МАКС\\IdeaProjects\\HomeWork-1\\chromedriver.exe");// путь к хромдрайверу
        Selenide.open(LoginPage_URL);
        UserName.setValue("tomsmith");
        Password.setValue("SuperSecretPassword!");
        Login.click();
        LogOut.shouldBe(Condition.exist);

        System.out.println("Успешная авторизация");
    }
    @Test
    public void negativeAuthorization() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\МАКС\\IdeaProjects\\HomeWork-1\\chromedriver.exe");// путь к хромдрайверу
        Selenide.open(LoginPage_URL);
        UserName.setValue("tomsmith1");
        Password.setValue("SuperSecretPassword!");
        Login.click();
        FailLogOut.shouldBe(Condition.exist);

        System.out.println("Авторизация провалена");
    }
}