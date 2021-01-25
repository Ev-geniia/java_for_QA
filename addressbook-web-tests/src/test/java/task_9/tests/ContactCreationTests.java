package task_9.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import task_9.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().gotoAddNewContactPage();
    app.getContactHelper().fillContactForm(new ContactData("firstname", "lastname", "address", "2128506", "mail@mail.com", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before +1);
  }


}
