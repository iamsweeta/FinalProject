import PageObjects.BasePage;
import PageObjects.LoginPage;
import PageObjects.PhotosPage;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("Тестирование загрузки фотографии")
public class PhotoTest extends LoginTest{
    private final static Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    @Test
    @Tag("Photo_Test")
    public void photoTest(){
        LOGGER.info("НАЧАЛО ТЕСТА ФОТОГРАФИЙ");
        BasePage basePage = new BasePage();
        PhotosPage photosPage = basePage.goToPhotosPage();
        photosPage.waitForLoad();
        int PREVIOUS_PHOTOS_AMOUNT = photosPage.countPhotos();
        photosPage.addPhoto();
        Assertions.assertNotEquals(PREVIOUS_PHOTOS_AMOUNT, photosPage.countPhotos());
    }

    @AfterAll
    @Tag("Delete_Photo")
    public static void deleteAddedPhoto(){
        LOGGER.info("УДАЛЯЕМ ФОТОГРАФИЮ");
        BasePage basePage = new BasePage();
        basePage.waitForLoad();
        PhotosPage photosPage = basePage.goToPhotosPage();
        photosPage.deletePhoto();
        Assertions.assertEquals(("Фотография удалена"+"\n"+"Восстановить"), photosPage.getText());
    }

}
