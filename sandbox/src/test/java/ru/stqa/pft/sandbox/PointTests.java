package ru.stqa.pft.sandbox;

import lesson1.task2.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(3,4);
    Assert.assertEquals(p1.distance(p2), 5);

  }

  @Test
  public void testDistance2() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(5,10);
    Assert.assertEquals(p1.distance(p2), 11.180339887498949);

  }
}
