
import Elements.Section;
import PageObjects.BasePage;
import ValueObject.UserData;
import PageObjects.LoginPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Тестирование авторизации")
public class LoginTest {
    UserData userData = new UserData("technopolisPassword", "technopol42");
    private final static Logger LOGGER = LoggerFactory.getLogger(LoginTest.class);

    @BeforeAll
    @Tag("Configuration")
    public static void config() {
        LOGGER.info("КОНФИГУРИРУЕМ БРАУЗЕР");
        Configuration.baseUrl = "https://ok.ru/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @Tag("LogIn")
    public void loginTest() {
        LOGGER.error("НАЧАЛО ВЫПОЛНЕНИЯ ТЕСТА");
        open("/", LoginPage.class).waitForLoad();
        LoginPage loginPage = new LoginPage();
        loginPage.waitForLoad();
        loginPage.authorize(userData.getLogin(), userData.getPassword());
        BasePage basePage = new BasePage();
        basePage.waitForLoad();
        Assertions.assertEquals(userData.getLogin() + " " + userData.getLogin(), basePage.getName());
    }

    @AfterAll
    public static void logOutTest() {
        BasePage basePage = new BasePage();
        basePage.logOut();
    }
}