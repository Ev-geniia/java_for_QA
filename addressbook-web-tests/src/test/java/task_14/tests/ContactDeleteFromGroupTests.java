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

public class ContactDeleteFromGroupTests extends TestBase{

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
  public void testContactDeleteFromGroup() {
    ContactData contact = selectContact();
    GroupData fromGroup = selectGroup(contact);
    Groups before = contact.getGroups();
    app.goTo().returnToHomePage();
    app.contact().groupPage(fromGroup.getId());
    app.contact().removeFromGroup(contact, fromGroup);
    ContactData contactAfter = selectContactById(contact);
    Groups after = contactAfter.getGroups();
    assertThat(after, equalTo(before.without(fromGroup)));
  }

  private ContactData selectContactById(ContactData contact) {
    Contacts contactById = app.db().contacts();
    return contactById.iterator().next().withId(contact.getId());
  }

  private ContactData selectContact() {
    Contacts allContacts = app.db().contacts();
    for (ContactData contact : allContacts) {
      if (contact.getGroups().size() > 0) {
        return contact;
      }
    }
    ContactData addContact = app.db().contacts().iterator().next();
    app.contact().addToGroup(addContact, app.db().groups().iterator().next());
    return addContact;
  }

  private GroupData selectGroup(ContactData removeContact) {
    ContactData contact = selectContactById(removeContact);
    Groups deletedContact = contact.getGroups();
    return deletedContact.iterator().next();
  }
}
