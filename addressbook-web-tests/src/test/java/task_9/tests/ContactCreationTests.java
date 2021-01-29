package task_9.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import task_9.model.ContactData;
import task_9.model.GroupData;

import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().gotoAddNewContactPage();
    app.getContactHelper().fillContactForm(new ContactData("firstname", "lastname", "address", "2128506", "mail@mail.com", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() +1);
  }


}
