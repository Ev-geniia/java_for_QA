package task_8.tests;

import org.testng.annotations.Test;
import task_8.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("firstname", "lastname", "address", "2128506", "mail@mail.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();

  }
}
