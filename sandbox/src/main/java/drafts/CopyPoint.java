package drafts;

public class CopyPoint {
  public double x;
  public double y;

  public CopyPoint(double x, double y) {
    this.x = x;
    this.y = y;
  }
  public double distance (CopyPoint p2) {
    double xdiff = this.x - p2.x;
    double ydiff = this.y - p2.y;
    double d = xdiff*xdiff + ydiff*ydiff;
    return Math.sqrt(d);
  }

  public double WonderMinus (CopyPoint p2) {
    double xdiff = this.x - p2.x;
    double ydiff = this.y - p2.y;
    return xdiff - ydiff;
  }

  public String describe () {
    return "x = " + this.x + " y = " + this.y;
  }

  public CopyPoint Minus (CopyPoint p2) {
    double xdiff = this.x - p2.x;
    double ydiff = this.y - p2.y;
    return new CopyPoint(xdiff, ydiff);

  }
  public CopyPoint Multiply(double d) {
    double xmult = this.x*d;
    double ymult = this.y*d;
    return new CopyPoint(xmult, ymult);

  }
  public CopyPoint Divide(double d) {
    double xdiv = this.x/d;
    double ydiv = this.y/d;
    return new CopyPoint(xdiv, ydiv);
  }

  public double MinDist(CopyPoint p1, CopyPoint p2) {
    double d1 = this.distance(p1);
    double d2 = this.distance(p2);
    return Math.min(d1, d2);
  }

}
