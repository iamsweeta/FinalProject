package Elements;
import com.codeborne.selenide.SelenideElement;

public class TextInput extends BaseElement{
    private SelenideElement TEXT_INPUT;
    public TextInput(SelenideElement TEXT_INPUT){
        super(TEXT_INPUT);
    }
    public void input(String text){
        TEXT_INPUT.setValue(text);
    }
}
