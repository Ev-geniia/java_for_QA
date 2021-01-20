package task_6.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion(){
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().returnToHomePage();
  }
}
