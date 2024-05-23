package PageObjects;

import Elements.Button;
import Elements.Section;
import Elements.TextInput;
import LoadableComponent.Loadable;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class VideoPage extends Loadable {
    private final Button CLOSE = new Button($(By.xpath("//button[@class='media-layer_close']")));
    private final Button VIDEO_SETTINGS = new Button($(By.xpath("//button[@aria-label='Настройки']")));
    private final Button SPEED = new Button($(By.xpath("//div[text()='Скорость']")));
    private final Button SELECT_SPEED = new Button(($(By.xpath("//div[text()='1.75x']"))));
    private final Section VIDEO_CARD = new Section($(By.xpath("//div[@data-module='VideoPreviewAutoplay']")));
    private final Section VIDEO = new Section($(By.xpath("//video[contains(@class, 'vid_display')]")));

    @Override
    public void waitForLoad(){
        VIDEO_CARD.element()
                .shouldBe(exist
                .because("Карточка не прогрузилось"));
    }

    public VideoPage changeSpeed(){
        VIDEO_CARD.element()
                  .shouldBe(exist
                  .because("Карточка не прогрузилась"))
                  .click();
        sleep(3000);
        VIDEO.element()
             .shouldBe(visible
             .because("Видео не отобразилось"))
             .click();
        VIDEO_SETTINGS.element()
                      .shouldBe(visible
                      .because("Настройки видео не отобразились"))
                      .click();
        SPEED.element()
                .shouldBe(visible
                .because("Кнопка СКОРОСТЬ не отобразилась"))
                .click();
        SELECT_SPEED.element()
                .shouldBe(visible
                .because("Кнопка выбра скорости не отобразилась"))
                .click();
        return page(VideoPage.class);
    }

    public String getSpeed(){
        return SELECT_SPEED.element()
                .getText();
    }
    public BasePage closeVideoPage(){
        CLOSE.element()
                .shouldBe(visible
                .because("Кнока ЗАКРЫТЬ не отобразилась"))
                .click();
        return page(BasePage.class);
    }
}
