package task_8.tests;

import org.testng.annotations.Test;
import task_8.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test_null", null, null));
  }

}
