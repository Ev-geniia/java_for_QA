package copyForLesson2_5.tests;

import copyForLesson2_5.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoAddNewContactPage();
    app.getContactHelper().fillContactForm(new ContactData("firstname", "lastname", "address", "2128506", "mail@mail.com"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    app.logout();
  }


}
