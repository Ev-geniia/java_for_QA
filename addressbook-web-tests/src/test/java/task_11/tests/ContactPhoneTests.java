package task_11.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import task_11.model.ContactData;

public class ContactPhoneTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("firstname").withLastname("lastname")
              .withAddress("address").withPhone("2128506").withEmail("mail@mail.com").withGroup("test1"));
    }
  }

  @Test
  public void testContactPhones() {
    app.goTo().returnToHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  }
}
