package PageObjects;

import Elements.Button;
import Elements.Section;
import Elements.TextInput;
import LoadableComponent.Loadable;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GiftsPage extends Loadable {
    private final Button CATEGORIES = new Button($(By.xpath("//button[text()='Категории']")));
    private final Button CREATE_GIFT = new Button($(By.xpath("//a[text()='Создай свой подарок']")));
    private final String TEXT = "СПАСИБО!";
    private final Button TEXT_GIFT = new Button($(By.xpath("//span[text()='текстовый']")));
    private final TextInput TEXT_INPUT = new TextInput($(By.xpath("//textarea[@class='con-text_input']")));
    private final Button ACCEPT = new Button($(By.xpath("//div[@id='id-ready_present_btn']")));
    private final Button MY_GIFTS = new Button($(By.xpath("//div[@class='con-ready_present']")));
    private final Section CREATED_GIFT = new Section($(By.xpath("//a[@class='gift2_link']")));

    @Override
    public void waitForLoad(){
        CATEGORIES.element()
                .shouldBe(exist
                .because("Кнопка КАТЕГОРИИ не прогрузилась"));
    }

    public GiftsPage createGift(){
        CATEGORIES.element()
                .shouldBe(visible
                .because("Кнопка КАТЕГОРИИ не отобразилась"))
                .click();
        CREATE_GIFT.element()
                .shouldBe(visible
                .because("Кнопка СОЗДАТЬ СВОЙ ПОДАРОК не отобразилась"))
                .click();
        sleep(2000);
        TEXT_GIFT.element()
                .shouldBe(visible
                .because("Кнопка СОЗДАТЬ ТЕКСТОВЫЙ ПОДАРОК не отобразилась"))
                .shouldBe(clickable)
                .click();
        TEXT_INPUT.element()
                .shouldBe(visible
                .because("Поле ввода текста не отобразилось"))
                .setValue(TEXT);
        ACCEPT.element()
                .shouldBe(visible
                .because("Кнопка ПРИНЯТЬ не отобразилась"))
                .click();
        MY_GIFTS.element()
                .shouldBe(visible
                .because("Кнопка МОИ ПОДАРКИ не отобразилась"))
                .click();
        return page(GiftsPage.class);
    }

    public boolean isGiftExist(){
        return CREATED_GIFT.element()
                .isDisplayed();
    }

}
