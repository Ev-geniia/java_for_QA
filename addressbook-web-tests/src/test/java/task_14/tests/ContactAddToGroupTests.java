package task_14.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import task_14.model.ContactData;
import task_14.model.Contacts;
import task_14.model.GroupData;
import task_14.model.Groups;

import java.util.Collection;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("precond_test"));
    }

    if (app.db().contacts().size() == 0) {
      app.goTo().returnToHomePage();
      app.contact().create(new ContactData().withFirstname("precond_firstname")
             .withLastname("precond_lastname").withAddress("address").withPhone("2128506")
              .withEmail("mail@mail.com"));
    }
  }

  @Test
  public void testContactAddToGroup() {
    ContactData contact = selectContact();
    GroupData toGroup = selectGroup(contact);
    Groups before = contact.getGroups();
    app.goTo().returnToHomePage();
    app.contact().addToGroup(contact, toGroup);
    ContactData contactAfter = selectContactById(contact);
    Groups after = contactAfter.getGroups();
    assertThat(after, equalTo(before.withAdded(toGroup)));
  }
  private ContactData selectContactById(ContactData contact) {
    Contacts contactById = app.db().contacts();
    return contactById.iterator().next().withId(contact.getId());
  }

  private ContactData selectContact() {
    Contacts allContacts = app.db().contacts();
    Groups allGroups = app.db().groups();
    for (ContactData contact : allContacts) {
      if (contact.getGroups().size() < allGroups.size()) {
        return contact;
      }
    }
    app.goTo().groupPage();
    app.group().create(new GroupData().withName("test0").withHeader("header0"));
    return allContacts.iterator().next();
  }

  private GroupData selectGroup(ContactData contact) {
    Groups allGroups = app.db().groups();
    Groups contactInGroups = contact.getGroups();
    Collection<GroupData> contactGroups = new HashSet<GroupData>(contactInGroups);
    Collection<GroupData> available = new HashSet<GroupData>(allGroups);
    available.removeAll(contactGroups);
    GroupData availableGroup = available.iterator().next();
    return availableGroup;
  }

}
