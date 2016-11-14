package threads;

import java.util.concurrent.atomic.AtomicInteger;

class Zad1demo extends Thread {
   private Thread t;
   private String threadName;
   private static int counter=0;
   private int counter2=0;
   static AtomicInteger atomicInteger = new AtomicInteger(0);
   
   
   Zad1demo(String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      System.out.println("Running " +  threadName );
      try {
         for(int i = 12; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            Thread.sleep(150);
            System.out.println("static " + counter++);
            System.out.println("-----  " + counter2++);
            System.out.println("atomic  " + atomicInteger.incrementAndGet());

         }
      }catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }
   
   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}

public class Zad1 {

   public static void main(String args[]) {
	  Zad1demo R1 = new Zad1demo( "Thread-1");
      R1.start();
      
      Zad1demo R2 = new Zad1demo( "Thread-2");
      R2.start();
   }   
}