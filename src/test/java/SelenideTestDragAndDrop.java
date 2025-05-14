import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTestDragAndDrop {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void checkTestDragAndDrop() {
        //команда dragAndDrop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        sleep(2000);
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-a").shouldHave(text("B"));
        sleep(2000);
    }

    @Test
    void checkTestActions() {
        //команда actions
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        sleep(1000);
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
        $("#column-a").shouldHave(text("B"));
        sleep(1000);

    }
}
