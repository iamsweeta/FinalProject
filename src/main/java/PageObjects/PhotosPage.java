package PageObjects;

import Elements.Button;
import Elements.FileInput;
import Elements.Section;
import LoadableComponent.Loadable;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PhotosPage extends Loadable {
    private final FileInput ADD_PHOTO = new FileInput($(By.xpath("//input[contains(@class, 'upload-link')]")));
    private final Section UPLOAD_IMG = new Section(($(By.xpath("//a[@data-l='t,goto-album']"))));
    private final Section COUNT_PHOTOS = new Section(($(By.xpath("//div[@class = 'count__x4tyv']"))));
    private final Section UPLOADED_PHOTO = new Section(($(By.xpath("//img[@class='photo-img__tt8r9']"))));
    private final Button ACTIONS = new Button(($(By.xpath("//button[contains(@class, 'action-button')]"))));
    private final Section STATE_SECTION = new Section($(By.xpath("//div[@class='action-bar__zvgsq']")));
    private final ElementsCollection BUTTONS = $$(By.xpath("//button[@class='link__ttg27']"));
    @Override
    public void waitForLoad(){
        ADD_PHOTO.element()
                .shouldBe(exist
                .because("Кнопка ДОБАВИТЬ ФОТО не прогрузилась"));}

    public void addPhoto(){
        ADD_PHOTO.element()
                .uploadFile(new java.io.File("src/image/аватрка.jpg"));
        UPLOAD_IMG.element()
                .shouldBe(visible
                .because("Элемент не отобразился"));
        sleep(5000);
    }

    public int countPhotos(){
        return Integer.parseInt(COUNT_PHOTOS.element()
                .shouldBe(visible
                .because("Элемент не отобразился"))
                .getText().charAt(0)+"");
    }

    public void deletePhoto(){
        UPLOADED_PHOTO.element()
                .shouldBe(visible
                .because("Фотография не отобразилась"))
                .click();
        ACTIONS.element()
                .shouldBe(exist
                .because("Кнопка ВЫБОР ДЕЙСТВИЯ не отобразилась"))
                .click();
        BUTTONS.get(BUTTONS.size() - 1)
                .shouldBe(exist
                .because("Кнопка УДАЛИТЬ ФОТОГРАФИЮ не отобразилась"))
                .click();
    }

    public String getText(){
        return STATE_SECTION.element()
                .shouldBe(visible
                .because("Панель состояния не отобразилась"))
                .getText();
    }

}
