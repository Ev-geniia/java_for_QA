package task_14.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import task_14.model.ContactData;
import task_14.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirstname("firstname").withLastname("lastname")
              .withAddress("address").withPhone("2128506").withEmail("mail@mail.com").withGroup("test1"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("firstname").withLastname("lastname")
            .withAddress("address").withPhone("2128506").withEmail("mail@mail.com");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    verifyContactListInUI();

  }
}