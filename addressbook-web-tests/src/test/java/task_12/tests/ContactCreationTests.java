package task_12.tests;


import org.testng.annotations.Test;
import task_12.model.ContactData;
import task_12.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("firstname").withLastname("lastname")
            .withAddress("address").withPhone("2128506").withEmail("mail@mail.com").withGroup("test1");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() +1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }


  @Test (enabled = false)
  public void testContactCreationWithPhoto() throws Exception {
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/stru.jpg");
    ContactData contact = new ContactData().withFirstname("firstname").withLastname("lastname")
            .withAddress("address").withPhone("2128506").withEmail("mail@mail.com").withGroup("test1").withPhoto(photo);
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() +1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test (enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/stru.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }

  @Test (enabled = false)
  public void testContactBadCreation() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("firstname'").withLastname("lastname'")
            .withAddress("address").withPhone("2128506").withEmail("mail@mail.com").withGroup("test1");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

}
