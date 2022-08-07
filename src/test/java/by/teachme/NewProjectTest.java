package by.teachme;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class NewProjectTest {
    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = "https://app.qase.io";
    }

    @Test
    public void newProjectTest() {
        new LoginPage().open()
                       .login();
        new ProjectsPage().createNewProject();
        $(id("inputTitle")).should(enabled).sendKeys("testNat");
        $(id("inputCode")).should(enabled).clear();
        $(id("inputCode")).sendKeys("TN");
        $(xpath("//button[text()='Create project']")).click();
        $(xpath("//h1[text()='TN']")).should(enabled);
        $(xpath("//a[text()='Projects']")).click();
        ElementsCollection tr = $(".table").$$("tr");
        SelenideElement rowForTextProject = tr.findBy(exactText("testNat"));
        assertThat($(xpath("//a[text()='testNat']"))
                .getText())
                .isNotNull()
                .isEqualTo("testNat");
        //$(xpath("")).click();
    }
}
