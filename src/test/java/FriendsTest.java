import PageObjects.BasePage;
import PageObjects.FriendPage;
import PageObjects.FriendsPage;
import PageObjects.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FriendsTest extends LoginTest{
    private final static Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    @Test
    @Tag("Send_Gift")
    public void friendsTest(){
        LOGGER.info("Начало теста. Отправление подарка");
        BasePage basePage = new BasePage();
        basePage.waitForLoad();
        FriendsPage friendsPage = basePage.goToFriendsPage();
        friendsPage.waitForLoad();
        FriendPage friendPage= friendsPage.goToMyFriendProfile();
        friendPage.waitForLoad();
        friendPage.sendCreatedGift();
        Assertions.assertTrue(friendPage.isSended());
    }
}
