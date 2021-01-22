package task_8.tests;

import org.testng.annotations.Test;
import task_8.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoAddNewContactPage();
    app.getContactHelper().fillContactForm(new ContactData("firstname", "lastname", "address", "2128506", "mail@mail.com", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }


}
