package PageObjects;

import Elements.Button;
import Elements.Section;
import Elements.TextInput;
import LoadableComponent.Loadable;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MusicPage extends Loadable {
    private final TextInput MUSIC_SEARCH = new TextInput($(By.xpath("//input[@placeholder='Поиск музыки']")));
    private final Button SEARCH = new Button($(By.xpath("//button[@class='submit-item']")));
    private final Section TRACK = new Section($(By.xpath("//wm-track[@data-tsid='track']")));
    private final Section TRACK_NAME = new Section($(By.xpath("//button[@data-tsid='track_name']")));
    private final Button ADD = new Button($(By.xpath("//wm-track-add-button[@class='action __add']")));
    private final Section MY_TRACK = new Section($(By.xpath("//wm-track[@data-tsid='track']")));
    private final Section FAVORITES = new Section($(By.xpath("//div[@data-l='t,library']")));
    @Override
    public void waitForLoad(){
        MUSIC_SEARCH.element()
                .shouldBe(exist
                .because("Поиск МУЗЫКИ не прогрузился"));
    }

    public MusicPage searchTrack(String track){
        MUSIC_SEARCH.element()
                .shouldBe(visible
                .because("Поиск МУЗЫКИ не отобразился"))
                .setValue(track);
        SEARCH.element()
                .shouldBe(visible
                .because("Кнопка ПОИСК не отобразилась"))
                .click();
        return page(MusicPage.class);
    }

    public String getText(){
        return TRACK_NAME.element()
                .shouldBe(visible
                .because("Название трека не отобразилась"))
                .getText();
    }

    public MusicPage addThisTrack(){
        TRACK.element()
             .shouldBe(visible
             .because("Элемент ТРЭК не отобразился"))
             .click();
        ADD.element()
                .shouldBe(visible
                .because("Элемент ДОБАВИТЬ не отобразился"))
                .click();
        return page(MusicPage.class);
    }

    public boolean isTrackAdded(){
        return MY_TRACK.element()
                .isDisplayed();
    }

    public MusicPage removeFromFav(){
        FAVORITES.element()
                .shouldBe(visible
                .because("МОЯ МУЗЫКА не отобразилась"))
                .click();
        MY_TRACK.element()
                .shouldBe(visible
                .because("Мой любимый трэк не отобразился"))
                .click();
        ADD.element()
                .shouldBe(visible
                .because("Кнопка УБРАТЬ не отобразилась"))
                .click();
        return page(MusicPage.class);
    }
}
