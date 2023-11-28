package HomeWork8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class KeyPresses {
    public static final String URL = "https://the-internet.herokuapp.com/key_presses";
    SelenideElement field = $x("//*[@id=\"target\"]");
    SelenideElement ALT = $x("//*[@id=\"result\"]");
    public static String text = "q";
    
    @Test
    public void sendKeyCheck() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\МАКС\\IdeaProjects\\HomeWork-1\\chromedriver.exe");// путь к хромдрайверу
        Selenide.open(URL);
        field.click();
        actions().sendKeys(text).perform();
        ALT.shouldHave(Condition.text("You entered: q"));

        System.out.println("Проверка завершена");
    }
}