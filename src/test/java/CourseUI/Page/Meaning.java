package CourseUI.Page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class Meaning {
public static SelenideElement entryField = $x("//input[@class='mini-suggest-form__input mini-suggest__input']");
public static SelenideElement cityBotton = $x("//a[@href='/pogoda/44?via=srp']");
public static ElementsCollection morning = $$x("//div[@style='grid-area: temperature-morning; padding: 10px 0px;']");
public static ElementsCollection days = $$x("//div[@style='grid-area: temperature-day; padding: 10px 0px;']");
public static ElementsCollection yesterday = $$x("//div[@style='grid-area: temperature-evening; padding: 10px 0px;']");
public static ElementsCollection night = $$x("//div[@style='grid-area: temperature-night; padding: 10px 0px;']");
public static ElementsCollection numberData = $$x("//p[@class='sc-77074498-0 fOAPuR']");
public static SelenideElement fieldCity = $x("//div[@class='link__condition day-anchor i-bem']");
}