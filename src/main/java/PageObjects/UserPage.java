package PageObjects;

import Elements.Button;
import Elements.FileInput;
import Elements.Section;
import LoadableComponent.Loadable;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class UserPage extends Loadable {
    private final Button ADD_PHOTO = new Button($(By.xpath("//div[@class='lcTc_avatar_lk']")));
    private final Section PHOTO = new Section($(By.xpath("//div[@class='grid_i__nuvr2']")));
    private final Button INSTALL = new Button($(By.xpath("//button[@class='button__pe9qo button-core-container__0ej09']")));
    private final Button INPUT_BUTTON = new Button($(By.xpath("//span[contains(@class,'input-file')]")));
    private final FileInput PHOTO_INPUT = new FileInput($(By.xpath("//input[contains(@class, 'input-file-input')]")));
    private final Button APPLY = new Button($(By.xpath("//button[@class='button__pe9qo button-core-container__0ej09']")));
    private final Section AVATAR = new Section($(By.xpath("//img[@id='viewImageLinkId']")));
    private final Logger LOGGER = LoggerFactory.getLogger(UserPage.class);
    @Override
    public void waitForLoad(){
        LOGGER.info("ПРОВЕРКА ПРОГРУЗКИ ЭЛЕМЕНТОВ НА СТРАНИЦЕ");
        ADD_PHOTO.element()
                .shouldBe(exist
                .because("Кнопка ДОБАВЛЕНИЕ ФОТО не прогрузилась"));
        INPUT_BUTTON.element()
                .shouldBe(exist
                .because("Кнопка ВЫБОР ФОТО не прогрузилась "));
    }

    public void addPhoto(){

        ADD_PHOTO.element()
                .shouldBe(visible
                .because("Кнопка ДОБАВИТЬ ФОТО не отобразилась"))
                .click();

        PHOTO.element()
                .shouldBe(visible
                .because("Фотография не отобразилась"))
                .click();
        //sleep(1000);
        PHOTO.element()
             .click();

        INSTALL.element()
                .shouldBe(clickable
                .because("Кнопка УСТАНОВИТЬ не прогрузилась"))
                .click();
    }

    public boolean isImageDisplayed(){
        return AVATAR.element()
                .isDisplayed();
    }


}
