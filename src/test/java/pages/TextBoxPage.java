package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    private final SelenideElement userNameInput = $("#userName"),

            userEmailInput = $("#userEmail"),

            userCurrentAddressInput = $("#currentAddress"),

            userPermanentAddressInput = $("#permanentAddress"),

            submitButton = $("#submit");

    public TextBoxPage openPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserPermanentAddress(String value) {
        userPermanentAddressInput.setValue(value);

        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();

    }

    public TextBoxPage checkResults(String key, String value) {
        $("#output").shouldHave(text(key + value));

        return this;
    }

}
