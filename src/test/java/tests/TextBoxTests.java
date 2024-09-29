package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;


public class TextBoxTests extends TestBase  {

    String userName = "Ivan Petrov";
    String userEmail = "abc@d.ru";
    String currentAddress = "Somewhere 123";
    String permanentAddress = "Some place nearby 14";

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {

        textBoxPage.openPage()
                .setUserName(userName)
                .setUserEmail(userEmail)
                .setUserCurrentAddress(currentAddress)
                .setUserPermanentAddress(permanentAddress)
                .clickSubmitButton();

        textBoxPage.checkResults("Name:", userName)
                .checkResults("Email:", userEmail)
                .checkResults("Current Address :", currentAddress)
                .checkResults("Permananet Address :", permanentAddress);
    }
}