package PageObjects;

import Elements.Button;
import Elements.Section;
import Elements.Sections;
import Elements.ToolBar;
import LoadableComponent.Loadable;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BasePage extends Loadable {
    private final Button APPLY_LOG_OUT = new Button($(By.xpath("//input[@data-l='t,logout']")));
    private final Section USER = new Section($(By.xpath("//div[@class='tico ellip']")));
    private final SelenideElement FRIENDS = new Sections().getFRIENDS();
    private final SelenideElement MUSIC = new ToolBar().getMusic();
    private final SelenideElement VIDEO = new ToolBar().getVideo();
    private final SelenideElement GIFTS = new Sections().getGifts();
    private final Button LOG_OUT = new Button($(By.xpath("//a[@data-l='t,logout']")));
    private final Button MENU = new Button($(By.xpath("//button[contains(@aria-controls, 'menu')]")));
    private final SelenideElement USER_SECTION = new Sections().getProfile();
    private final Section FRIENDS_SECTION = new Section($(By.xpath("//a[@data-l='t,userFriend']")));
    private final Section PHOTOS_SECTION = new Section($(By.xpath("//a[@data-l='t,userPhotos']")));
    private final static Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);


    @Override
    public void waitForLoad(){
        LOGGER.info("Ждем загрузки компонентов");
        MENU.element()
                .shouldBe(exist
                .because("Поле меню не прогрузилось"));
        USER_SECTION.shouldBe(exist
                .because("Поле СТРАНИЦА ПОЛЬЗОВАТЕЛЯ не прогрузилось"));
        FRIENDS_SECTION.element()
                .shouldBe(exist
                .because("Поле ДРУЗЬЯ не прогрузилось"));
    }
    public UserPage goToUserPage(){
        LOGGER.info("Переходим на страницу пользователя");
        USER_SECTION.shouldBe(visible
                .because("Раздел СТРАНИЦА ПОЛЬЗОВАТЕЛЯ не отобразился"))
                .click();
        return page(UserPage.class);
    }

    public PhotosPage goToPhotosPage(){
        LOGGER.info("Переходим на страницу ФОТО");
        PHOTOS_SECTION.element()
                .shouldBe(visible
                .because("Раздел ФОТО не отобразился"))
                .click();
        return page(PhotosPage.class);
    }

    public MusicPage goToMusicPage(){
        LOGGER.info("Переходим на страницу МУЗЫКА");
        MUSIC.shouldBe(visible
                .because("Элемент МУЗЫКА не отобразился"))
                .click();
        return page(MusicPage.class);
    }

    public VideoPage goToVideoPage(){
        LOGGER.info("Переходим на страницу ВИДЕО");
        VIDEO.shouldBe(visible
                .because("Элемент ВИДЕО не отобразился"))
                .click();
        return page(VideoPage.class);
    }

    public GiftsPage goToGiftsPage(){
        LOGGER.info("Переходим на страницу ПОДАРКИ");
        GIFTS.shouldBe(visible
                .because("Элемент ПОДАРКИ не отобразился"))
                .click();
        return page(GiftsPage.class);
    }
    public FriendsPage goToFriendsPage(){
        LOGGER.info("Переходим на страницу ДРУЗЬЯ");
        FRIENDS.shouldBe(visible
                .because("Элемент ДРУЗЬЯ не отобразился"))
                .click();
        return page(FriendsPage.class);
    }
    public String getName(){
        return USER.element()
                .shouldBe(visible)
                .getText();
    }

    public void logOut(){
        MENU.element()
                .shouldBe(visible
                .because("Элемент МЕНЮ не отобразился"))
                .click();
        LOG_OUT.element()
                .shouldBe(visible
                .because("Элемент ВЫЙТИ не отобразился"))
                .click();
        APPLY_LOG_OUT.element()
                .shouldBe(visible
                .because("Элемент ПОДТВЕРДИТЬ ВЫХОД не отобразился"))
                .click();
    }
}
