import PageObjects.BasePage;
import PageObjects.GiftsPage;
import PageObjects.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;

@DisplayName("Тестирование подарков")
public class GiftsTest extends LoginTest{
    private final static Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    @Test
    @Tag("Create_Gift")
    public void giftTest(){
        LOGGER.info("Начало теста. Создание подарка");
        BasePage basePage = new BasePage();
        basePage.waitForLoad();
        GiftsPage giftsPage = basePage.goToGiftsPage();
        giftsPage.waitForLoad();
        giftsPage.createGift();
        Assertions.assertTrue(giftsPage.isGiftExist());
    }
}
