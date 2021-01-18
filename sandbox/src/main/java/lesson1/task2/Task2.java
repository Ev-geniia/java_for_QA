package lesson1.task2;

public class Task2 {
  public static void main(String[] args) {
    Point p1 = new Point (1,2);
    Point p2 = new Point (4,6);
    System.out.println("Distance between points with coordinates " + p1.x + ", " + p1.y + " and " + p2.x + ", " + p2.y + " is equal to " + p1.distance(p2));
  }


}
