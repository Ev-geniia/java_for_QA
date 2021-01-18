package lesson1.task2;

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }
  public double distance (Point p2) {
    double xdiff = this.x - p2.x;
    double ydiff = this.y - p2.y;
    double d = xdiff*xdiff + ydiff*ydiff;
    return Math.sqrt(d);
  }

}
