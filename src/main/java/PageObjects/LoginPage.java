package PageObjects;

import Elements.Button;
import Elements.Section;
import Elements.TextInput;
import LoadableComponent.Loadable;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends Loadable {
    private final TextInput LOGIN_INPUT = new TextInput($(By.xpath("//input[@name='st.email']")));
    private final TextInput PASSWORD_INPUT = new TextInput($(By.xpath("//input[@name='st.password']")));
    private final Button SIGN_IN = new Button($(By.xpath("//input[@data-l='t,sign_in']")));
    private final Section ERROR = new Section($(By.xpath("//div[@class='input-e login_error']")));

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    @Override
    public void waitForLoad(){
        LOGIN_INPUT.element()
                .shouldBe(exist
                .because("Поле логина не прогрузилось"));

        PASSWORD_INPUT.element()
                .shouldBe(exist
                .because("Поле пароля не прогрузилось"));

        SIGN_IN.element()
                .shouldBe(exist
                .because("Кнопка авторизации не прогрузилось"));
    }

    public BasePage authorize(String login, String password){
        LOGGER.info("ВВОДИМ ЛОГИН");
        LOGIN_INPUT.element()
                .shouldBe(visible
                .because("Поле логина не отобразилось"))
                .setValue(login);

        LOGGER.info("ВВОДИМ ПАРОЛЬ");
        PASSWORD_INPUT.element()
                .shouldBe(visible
                .because("Поле пароля не отобразилось"))
                .setValue(password);

        LOGGER.info("АВТОРИЗИРУЕМСЯ");
        SIGN_IN.element()
                .shouldBe(visible
                .because("Поле пароля не отобразилось"))
                .click();
        return page(BasePage.class);
    }

    public boolean isError(){
        return ERROR.element()
                .isDisplayed();
    }

}
