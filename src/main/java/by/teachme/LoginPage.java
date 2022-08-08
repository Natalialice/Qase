package by.teachme;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class LoginPage {
    public LoginPage open() {
        Selenide.open("/login");
        return new LoginPage();
    }

    public LoginPage login() {
        $(id("inputEmail")).should(Condition.enabled).sendKeys("natalithewolf@gmail.com");
        $(id("inputPassword")).sendKeys("12345678");
        $(id("btnLogin")).click();
        return new LoginPage(); //  поменять на класс Progects  и создасть пайдж
    }
}
