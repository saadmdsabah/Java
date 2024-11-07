package AdvancedClasses;
public class ArgsExample {

  static class Int<T> {

    T value;

    public Int(T value) {
      this.value = value;
    }

    public T getValue() {
      return value;
    }
  }

  static class IntClass {

    int value;

    public IntClass(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  public static void main(String[] args) {
    Int<Integer> i = new Int<>(5);
    IntClass i2 = new IntClass(5);
    System.out.println(i.getValue());
    System.out.println(i2.getValue());
  }
}
