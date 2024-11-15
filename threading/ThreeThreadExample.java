package threading;

public class ThreeThreadExample {

    static int value = 0;
    static final Object lock = new Object();
    static boolean isIncremented = false;
    static boolean isPrinted = false;

    static class CustomThread extends Thread {
        int threadNumber;

        public CustomThread(int threadNumber) {
            this.threadNumber = threadNumber;
        }

        public void run() {
            switch (threadNumber) {
                case 1 -> incrementValue();
                case 2 -> printValue();
                case 3 -> finalAction();
            }
        }

        private void incrementValue() {
            synchronized (lock) {
                System.out.println("Thread 1: Incrementing value...");
                value++;
                isIncremented = true;
                lock.notifyAll(); // Notify waiting threads (Thread 2)
            }
        }

        private void printValue() {
            synchronized (lock) {
                try {
                    while (!isIncremented) { // Wait until value is incremented
                        System.out.println("Thread 2: Waiting for value to be incremented...");
                        lock.wait();
                    }
                    System.out.println("Thread 2: Value is " + value);
                    isPrinted = true;
                    lock.notifyAll(); // Notify waiting threads (Thread 3)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void finalAction() {
            synchronized (lock) {
                try {
                    while (!isPrinted) { // Wait until value is printed
                        System.out.println("Thread 3: Waiting for value to be printed...");
                        lock.wait();
                    }
                    System.out.println("Thread 3: Performing final action with value " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        CustomThread thread1 = new CustomThread(1);
        CustomThread thread2 = new CustomThread(2);
        CustomThread thread3 = new CustomThread(3);

        thread3.start(); // Start Thread 3 first, it will wait
        thread2.start(); // Start Thread 2 next, it will wait
        thread1.start(); // Start Thread 1 last, it will increment and notify
    }
}
