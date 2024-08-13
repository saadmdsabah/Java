
class Shape {
    public void area(){
        System.out.println("displays area");
    }
}

// Single level inheritance
class Triangle extends Shape {
    public void area(int l, int h){
        System.out.println(0.5*l*h);
    }
}

// Herarchial inheritance means two or more have same parent class like circle and triangle class having same parent Shape therefore hierarchial inheritance
class Circle extends Shape {
    public void area(int r){
        System.out.println(3.14*r*r);
    }
}

// multi level inheritance
class EquilateralTriangle extends Triangle {
    public void area(int l, int h){
        System.out.println(0.5*l*h);
    }
}

// hybrid inheritance: having moret than one inheritance like having one multi and a Herarchial inheritance

public class inheritance {
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        t1.area(3,4);
    }
}
