package oop1314.lab01;
class CallByValueExample2 {

  void increment(Point3D p){
    p.x++;
    p.y++;
    p.z++;
  }
  
  public static void main(String[] args) {
    Point3D p = new Point3D();
    p.build(1, 2, 3);
    CallByValueExample2 cbv2 = new CallByValueExample2();
    cbv2.increment(p);
    System.out.println("x=" + p.x + ";y=" + p.y + ";z=" + p.z);
  }
}
