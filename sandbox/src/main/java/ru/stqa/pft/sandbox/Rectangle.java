package ru.stqa.pft.sandbox;

public class Rectangle {
  public double l;
  public double w;

  public Rectangle(double l, double w) {
    this.l = l;
    this.w = w;
  }

  public double area() {
    return this.l * this.w;
  }
}
