package HomeWork8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$x;

public class CheckBoxes {
    public static final String checkBoxesURL = "https://the-internet.herokuapp.com/checkboxes";
    static SelenideElement checkBoxes1 = $x("//input[@type='checkbox'][1]");
    static SelenideElement getCheckBoxes2 = $x("//input[@type='checkbox'][2]");
    @Test
    public void testingCheckBoxes(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\МАКС\\IdeaProjects\\HomeWork-1\\chromedriver.exe");// путь к хромдрайверу
        Selenide.open(checkBoxesURL);
        checkBoxes1.click();
        checkBoxes1.shouldBe(Condition.selected);
        getCheckBoxes2.click();
        getCheckBoxes2.shouldNotBe(Condition.selected);

        System.out.println("Проверка CheckBoxes");
    }
}