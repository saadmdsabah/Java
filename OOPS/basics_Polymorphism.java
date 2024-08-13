
class Pen {
    // 
    String color;
    String type;

    // Constructor Non-Parameterized
    Pen(){
        System.out.println("Non-Parameterized");
    }

    // Methods
    public void write(){
        System.out.println("Writing somthing");
    }
    public void printColor(){
        System.out.println(this.color);
    }
    public void printType(){
        System.out.println(this.type);
    }
}

class Student {
    String name;
    int age;

    // Constructor Parameterized
    Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    // Copy Constructor as we are taking another Student as a input.
    // Student(Student s1){
    //     this.name = s1.name;
    //     this.age = s1.age;
    // }

    // ##################################################################################################
    // Polymorphism : poly->Manu, Morphism->forms means doing one thing in different forms
    // 2 Types of Polymorphism: 1) Function overloading->Compile time,  2) Function Overriding->Run time

    // Function Overloading : Different functions with functionality functinality in a class having same name
    // Rules for poly : either their return types must br different or their input types must be different.
    // ##################################################################################################

    public void printInfo(){
        System.out.println(this.name);
        System.out.println(this.age);
    }
    public void printInfo(String n){
        System.out.println(n);
    }
    public void printInfo(int age){
        System.out.println(age);
    }
}

public class basics_Polymorphism {
    public static void main(String[] args) {
        Student s1 = new Student("Saad",19);
        s1.printInfo(23);
    }
}