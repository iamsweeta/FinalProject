import PageObjects.BasePage;
import PageObjects.LoginPage;
import PageObjects.MusicPage;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@DisplayName("Тестирования музыки")
public class MusicTest extends LoginTest{
    private final static Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);
    private final String TRACK = "Каждый раз";

    @Test
    @Tag("MusicSearch")
    public void musicTest(){
        LOGGER.info("Начало теста МУЗЫКИ");
        BasePage basePage = new BasePage();
        basePage.waitForLoad();
        MusicPage musicPage = basePage.goToMusicPage();
        musicPage.waitForLoad();
        musicPage.searchTrack(TRACK);
        LOGGER.info("Проверяем, совпадают ли названия треков, понижаем регистр");
        Assertions.assertEquals(TRACK.toLowerCase(), musicPage.getText().toLowerCase());
    }

    @Test
    @Tag("Add_Music_Test")
    public void addTrackTest(){
        LOGGER.info("Добавляем трек");
        MusicPage musicPage = new MusicPage();
        musicPage.addThisTrack();
        Assertions.assertTrue(musicPage.isTrackAdded(), "Трек не был добавлен");
    }

    @AfterAll
    @Tag("Remove_Track")
    public static void removeTrackTest(){
        LOGGER.info("Удаляем трек из любиымых");
        MusicPage musicPage = new MusicPage();
        musicPage.removeFromFav();
        Assertions.assertFalse(musicPage.isTrackAdded());
    }
}
