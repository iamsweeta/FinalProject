import PageObjects.BasePage;
import PageObjects.LoginPage;
import PageObjects.UserPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("Тестирование изменения аватара")
public class AvatarTest extends PhotoTest{
    private final static Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    @Test
    @Tag("Change_Avatar")
    public void avatarTest(){
        BasePage basePage = new BasePage();
        basePage.waitForLoad();
        UserPage userPage = basePage.goToUserPage();
        userPage.waitForLoad();
        userPage.addPhoto();
        Assertions.assertTrue(userPage.isImageDisplayed());
    }
}
