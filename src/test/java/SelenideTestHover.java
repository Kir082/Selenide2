import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTestHover {
    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void checkTestHover() {
        open("https://github.com");
        $$("button[class^='HeaderMenu-link']").findBy(text("Solutions")).hover();
        $$("a[class^='HeaderMenu-dropdown-link']").findBy(text("Enterprise")).click();
        $("h1[id='hero-section-brand-heading']").shouldHave(text("The AI-powered"));

    }



}
