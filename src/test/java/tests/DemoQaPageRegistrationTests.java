package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaPageRegistrationTests extends TestBase {



    RegistrationPage registartionPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registartionPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Petrov")
                .setEmail("ab@ya.ru")
                .setGender("Male")
                .setPhoneNumber("0123456789")
                .setDateOfBirth("30", "July", "2008");





        $("#hobbiesWrapper").find("label[for='hobbies-checkbox-1']").click();
        $("#hobbiesWrapper").find("label[for='hobbies-checkbox-2']").click();
        $("#hobbiesWrapper").find("label[for='hobbies-checkbox-3']").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#subjectsInput").setValue("Arts").pressEnter();

        $("#uploadPicture").uploadFromClasspath("1.jpg");


        $("#currentAddress").setValue("Somewhere Street 21/23");

        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();

        // Проверка результатов теста

        registartionPage.checkResults("Student Name", "Ivan Petrov")
                        .checkResults("Student Email", "ab@ya.ru")
                        .checkResults("Gender", "Male")
                        .checkResults("Mobile", "0123456789")
                        .checkResults("Date of Birth", "30 July,2008")
                        .checkResults("Subjects", "Computer Science, Arts")
                        .checkResults("Hobbies", "Sports, Reading, Music")
                        .checkResults("Picture", "1.jpg")
                        .checkResults("Address", "Somewhere Street 21/23")
                        .checkResults("State and City", "Haryana Karnal");

        System.out.println("Тест пройден успешно");
    }

}
