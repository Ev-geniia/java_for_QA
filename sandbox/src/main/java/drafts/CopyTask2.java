package drafts;


public class CopyTask2 {
  public static void main(String[] args) {
    CopyPoint p1 = new CopyPoint (5,7);
    CopyPoint p2 = new CopyPoint (4,6);
//    System.out.println("Distance is equal to " + distance(p1, p2));
    System.out.println("Distance is equal to " + p1.distance(p2));
    System.out.println(p1.describe());
    System.out.println(p2.describe());

    double d = 10;
    CopyPoint p3 = p1.Multiply(d);
    System.out.println(p3.describe());
    CopyPoint p4 = p3.Divide(d);
    System.out.println(p4.describe());


  }


}
