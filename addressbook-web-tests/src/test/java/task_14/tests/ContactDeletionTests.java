package task_14.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import task_14.model.ContactData;
import task_14.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("firstname").withLastname("lastname")
              .withAddress("address").withPhone("2128506").withEmail("mail@mail.com").withGroup("test1"));
    }
  }

  @Test
  public void testContactDeletion(){
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() -1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
