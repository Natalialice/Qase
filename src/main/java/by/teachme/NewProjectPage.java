package by.teachme;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class NewProjectPage {
    public NewProjectPage open() {
        $(id("createButton")).should(Condition.enabled).click();;
        return new NewProjectPage();
    }
}
