import java.util.Scanner;

public class P_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create 5 Threads");
            System.out.println("2. Print 2's and 5's table using Synchronized Methods");
            System.out.println("3. Demonstrate Daemon Thread");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createThreads();
                    break;
                case 2:
                    printTables();
                    break;
                case 3:
                    demonstrateDaemonThread();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to create 5 threads
    public static void createThreads() {
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(new SimpleRunnable(i));
            thread.start();
        }
    }

    // Method to print tables using synchronized methods
    public static void printTables() {
        TablePrinter printer = new TablePrinter();
        Thread t1 = new Thread(() -> printer.printTable2());
        Thread t2 = new Thread(() -> printer.printTable5());

        t1.start();
        t2.start();
    }

    // Method to demonstrate daemon thread
    public static void demonstrateDaemonThread() {
        Thread daemonThread = new Thread(new DaemonRunnable());
        daemonThread.setDaemon(true);
        daemonThread.start();

        // Main thread sleeps for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");
    }
}

class SimpleRunnable implements Runnable {
    private int threadNumber;

    public SimpleRunnable(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        System.out.println("Thread " + threadNumber + " is running.");
    }
}

class TablePrinter {
    // Synchronized method to print 2's table
    public synchronized void printTable2() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("2 * " + i + " = " + (2 * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Synchronized method to print 5's table
    public synchronized void printTable5() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("5 * " + i + " = " + (5 * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DaemonRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("Daemon thread is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
