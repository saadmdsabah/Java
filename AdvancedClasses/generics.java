package AdvancedClasses;
public class generics {

  static class Node<T> {

    private T value;

    public Node(T value) {
      this.value = value;
    }

    public T getValue() {
      return value;
    }

    public void printAble(T newValue) {
      System.out.println(newValue);
    }

    public String toString() {
      return String.valueOf(value);
    }

    public String convertUsing(T temp, String str) {
      return temp + str;
    }
  }

  public static void main(String[] args) {
    Node<Integer> value = new Node<>(3);
    System.out.println(value.getValue());
    value.printAble(34);
    System.out.println(value.toString());
    System.out.println(value.convertUsing(34, "hello"));
  }
}
