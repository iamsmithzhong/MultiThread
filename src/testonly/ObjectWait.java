package testonly;

public class ObjectWait{
   public static Object  object = new Object();
   static class Thread1 extends Thread{
       @Override
       public void run() {
           synchronized (object) {
               try {
            	   Thread.currentThread().sleep(5000);
            	   System.out.println("线程"+Thread.currentThread().getName()+"开始wait");
                   object.wait();
               } catch (InterruptedException e) {
               }
               System.out.println("线程"+Thread.currentThread().getName()+"获取到了锁");
           }
       }
   }
   
   static class Thread2 extends Thread{
       @Override
       public void run() {
           synchronized (object) {
        	   System.out.println("线程"+Thread.currentThread().getName()+"开始notify");
               object.notify();
               System.out.println("线程"+Thread.currentThread().getName()+"调用了object.notify()");
           }
           System.out.println("线程"+Thread.currentThread().getName()+"释放了锁");
       }
   }
    
   public static void main(String[] args) {
       Thread1 thread1 = new Thread1();
       Thread2 thread2 = new Thread2();
     
        
       thread1.start();
//        
//       try {
//           Thread.sleep(200);
//       } catch (InterruptedException e) {
//           e.printStackTrace();
//       }
       thread2.start();
       //thread2.start();
   }
}