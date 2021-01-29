package task_9.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import task_9.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion(){
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("firstname", "lastname", "address", "2128506", "mail@mail.com", "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContactHomePage(before.size() - 1);
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().confirmContactDeletion();
    app.getNavigationHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() -1);
  }
}
