package Elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ToolBar{
    private final SelenideElement MUSIC = $(By.xpath("//li[@data-l='t,music']"));
    private final SelenideElement VIDEO = $(By.xpath("//li[@data-l='t,video']"));
    public SelenideElement getMusic(){
        return MUSIC;
    }
    public SelenideElement getVideo(){
        return VIDEO;
    }
}
