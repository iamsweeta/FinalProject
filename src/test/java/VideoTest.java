import PageObjects.BasePage;
import PageObjects.LoginPage;
import PageObjects.VideoPage;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("Тестирование изменения скорости видео")
public class VideoTest extends LoginTest{
    private final static Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);
    private final String EXPECTED_SPEED ="1.75x";
    @Test
    @Tag("Change_Speed")
    public void videoTest(){
        LOGGER.info("Начало тестирования видео");
        BasePage basePage = new BasePage();
        basePage.waitForLoad();
        VideoPage videoPage = basePage.goToVideoPage();
        videoPage.waitForLoad();
        videoPage.changeSpeed();
        String ACTUAL_SPEED = videoPage.getSpeed();
        Assertions.assertEquals(EXPECTED_SPEED, ACTUAL_SPEED);
    }

    @AfterAll
    @Tag("Close_Videos")
    public static void closeVideoTest(){
        LOGGER.info("Закрываем браузер");
        VideoPage videoPage = new VideoPage();
        videoPage.closeVideoPage();
    }
}
