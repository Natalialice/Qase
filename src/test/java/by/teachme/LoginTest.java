package by.teachme;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.openqa.selenium.By.id;

@Listeners({ScreenShooter.class})

public class LoginTest {
    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = "https://app.qase.io";
    }

    @Test
    public void firstTest() {
        new LoginPage().open()
                       .login();
        $(id("createButton")).shouldHave(text("Create new project"));
        assertThat($(id("createButton")).getText()).isNotNull()
                                                   .isEqualTo("Create new project");
        ElementsCollection tr = $(".table").$$("tr");
//        SelenideElement rowForTextProject = tr.findBy(exactText("text"));


    }


}
