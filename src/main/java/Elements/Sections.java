package Elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Sections {
    private final SelenideElement GIFTS = $(By.xpath("//a[@data-l='t,giftsFront']"));
    private final SelenideElement PROFILE = $(By.xpath("//a[@data-l='t,userPage']"));
    private final SelenideElement FRIENDS = $(By.xpath("//a[@data-l='t,userFriend']"));
    public SelenideElement getGifts(){
        return GIFTS;
    }

    public SelenideElement getProfile(){
        return PROFILE;
    }
    public SelenideElement getFRIENDS(){
        return FRIENDS;
    }

}
