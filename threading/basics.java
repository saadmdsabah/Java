package threading;

class A implements Runnable {

  private int threadNumber;

  public A(int threadNumber) {
    this.threadNumber = threadNumber;
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println(i + " from thread number - " + this.threadNumber);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class basics {

  public static void main(String[] args) {
    A a = new A(23);
    Thread newThread = new Thread(a);
    newThread.start();
    try {
      newThread.join();
      System.out.println(newThread.getState());
    } catch (InterruptedException e) {}
  }
}
