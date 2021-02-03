package task_11.tests;

import org.testng.annotations.Test;
import task_11.model.ContactData;

public class ContactAddressTests extends TestBase {

  @Test
  public void testContactAddress() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

  }
}
