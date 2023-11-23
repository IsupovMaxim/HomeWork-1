package HomeWork8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$x;

public class Hovers {
    public static final String URL = "http://the-internet.herokuapp.com/hovers";
    SelenideElement user1 = $x("//*[@id=\"content\"]/div/div[1]/img");
    SelenideElement text = $x("//*[@id=\"content\"]/div/div[1]/div/h5");

    @Test
    public void chekingUserText() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\МАКС\\IdeaProjects\\HomeWork-1\\chromedriver.exe");// путь к хромдрайверу
        Selenide.open(URL);
        user1.hover();
        text.shouldNotBe(Condition.checked);

        System.out.println("Успешная проверка ");
    }
}