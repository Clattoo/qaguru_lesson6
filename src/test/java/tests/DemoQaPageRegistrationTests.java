package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class DemoQaPageRegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Petrov")
                .setEmail("ab@ya.ru")
                .setGender("Male")
                .setPhoneNumber("0123456789")
                .setDateOfBirth("30", "July", "2008")
                .setSubjects("Physics")
                .setHobbies("Sports")
                .setUserUploadPicture("1.jpg")
                .setUserCurrentAddress("Somewhere Street 21/23")
                .setUserState("Haryana")
                .setUserCity("Karnal")
                .clickSubmit();


        // Проверка результатов теста

        registrationPage.checkResults("Student Name", "Ivan Petrov")
                        .checkResults("Student Email", "ab@ya.ru")
                        .checkResults("Gender", "Male")
                        .checkResults("Mobile", "0123456789")
                        .checkResults("Date of Birth", "30 July,2008")
                        .checkResults("Subjects", "Physics")
                        .checkResults("Hobbies", "Sports")
                        .checkResults("Picture", "1.jpg")
                        .checkResults("Address", "Somewhere Street 21/23")
                        .checkResults("State and City", "Haryana Karnal");
    }

    @Test
    public void successfulMinDataRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Petrov")
                .setGender("Female")
                .setPhoneNumber("89112312323")
                .clickSubmit();

        // Проверка результатов теста

        registrationPage.checkResults("Student Name", "Ivan Petrov")
                .checkResults("Gender", "Female")
                .checkResults("Mobile", "8911231232");
    }

    @Test
    public void negativeRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Petrov")
                .setGender("Female")
                .setPhoneNumber("ABSCDS")
                .clickSubmit();

        // Проверка результатов теста

        registrationPage.checkUnsuccessfulRegistration();
    }

}
