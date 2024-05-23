package PageObjects;

import Elements.Button;
import Elements.Section;
import LoadableComponent.Loadable;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FriendPage extends Loadable {
    private final Button MORE = new Button($(By.xpath("//button[@aria-label='Ещё']")));
    private final Button MAKE_GIFT = new Button($(By.xpath("//a[text()='Сделать подарок']")));
    private final Button MY_GIFTS = new Button($(By.xpath("//button[text()='Мои подарки']")));
    private final Button CREATED = new Button($(By.xpath("//a[text()='Созданные']")));
    private final Section CREATED_GIFT = new Section($(By.xpath("//a[@class='gift2_link']")));
    private final Section SEND = new Section($(By.xpath("//button[@class='js-submit-to-friend button-pro __ic']")));
    private final Section IS_SENDED = new Section($(By.xpath("//div[text()='отправлен']")));


    @Override
    public void waitForLoad(){
        MORE.element()
                .shouldBe(exist
                .because("Кнопка ЕЩЕ не прогрузилась"));
    }

    public void sendCreatedGift(){
        MORE.element()
            .shouldBe(visible
            .because("Кнопка ЕЩЕ не отобразилась"))
            .click();
        MAKE_GIFT.element()
                .shouldBe(visible
                .because("Кнопка СДЕЛАТЬ ПОДАРОК не отобразилась"))
                .click();
        MY_GIFTS.element()
                .shouldBe(visible
                .because("Кнопка МОИ ПОДАРОКИ не отобразилась"))
                .click();
        CREATED.element()
                .shouldBe(visible
                .because("Кнопка СОЗДАННЫЕ не отобразилась"))
                .click();
        CREATED_GIFT.element()
                .shouldBe(visible
                .because("Подарок не отобразился"))
                .click();
        SEND.element()
                .shouldBe(visible
                .because("Кнопка ОТПРАВИТЬ не прогрузилась"))
                .click();
    }
    public boolean isSended(){
        return IS_SENDED.element()
                .isDisplayed();
    }
}
