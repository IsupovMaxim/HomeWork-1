package HomeWork8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.$x;

public class DynamicallyLoadedPage {
    public static final String URL = "https://the-internet.herokuapp.com/dynamic_loading/2";
    SelenideElement start = $x("//*[@id=\"start\"]/button");
    SelenideElement text = $x("//*[@id=\"finish\"]/h4");

    @Test
    public void waitForTextAfteLoading() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\МАКС\\IdeaProjects\\HomeWork-1\\chromedriver.exe");// путь к хромдрайверу
        Selenide.open(URL);
        start.click();
        Configuration.timeout = 10000;
        text.shouldHave(Condition.visible);

        System.out.println("Проверка завершена");
    }
}