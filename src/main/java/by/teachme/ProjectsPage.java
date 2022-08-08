package by.teachme;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class ProjectsPage {
    public ProjectsPage open() {
        Selenide.open("/projects");
        return new ProjectsPage();
    }

    public ProjectsPage createNewProject() {
        $(id("createButton")).should(Condition.enabled).click();
        return new ProjectsPage(); //  поменять на класс Progects  и создасть пайдж
    }

}
