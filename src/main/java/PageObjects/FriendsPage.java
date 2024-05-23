package PageObjects;

import Elements.Button;
import Elements.Section;
import Elements.TextInput;
import LoadableComponent.Loadable;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FriendsPage extends Loadable {
    private final Section MY_FRIEND = new Section($(By.xpath("//div[@class='user-grid-card_avatar']")));
    @Override
    public void waitForLoad(){
        MY_FRIEND.element()
                .shouldBe(exist
                .because("Карточка профиля друга не прогрузилась"));
    }

    public FriendPage goToMyFriendProfile(){
        MY_FRIEND.element()
                .shouldBe(visible
                .because("Элемент профиля друга не отобразился"))
                .click();
        return page(FriendPage.class);
    }



}
