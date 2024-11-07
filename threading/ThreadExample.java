package threading;

public class ThreadExample {

  static int value = 0;
  static final Object lock = new Object();

  static class A extends Thread {

    int threadNumber;

    public A(int threadNumber) {
      this.threadNumber = threadNumber;
    }

    public void run() {
      if (threadNumber == 1) {
        incrementValue();
      } else {
        printValue();
      }
    }

    private void incrementValue() {
      synchronized (lock) {
        System.out.println("Thread 1: Incrementing value...");
        value++;
        lock.notify(); // Notify the waiting thread
      }
    }

    private void printValue() {
      synchronized (lock) {
        try {
          System.out.println(
            "Thread 2: Waiting for value to be incremented..."
          );
          lock.wait(); // Wait for notification from Thread 1
          System.out.println("Thread 2: Value is " + value);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void main(String[] args) {
    A thread1 = new A(1);
    A thread2 = new A(2);

    thread2.start(); // Start thread 2, which will wait
    thread1.start(); // Start thread 1, which increments and notifies
  }
}
