package testonly;

import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicStampedReferenceTest {

	public final static AtomicStampedReference <String>ATOMIC_REFERENCE = new AtomicStampedReference<String>("abc" , 0);  
    static ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) {
        for(int i = 0 ; i < 100 ; i++) {  
            final int num = i;  
            final int stamp = ATOMIC_REFERENCE.getStamp();
            new Thread() {  
                public void run() {
                    lock.lock();
                    lock.unlock();
                   
                    try {
                        Thread.sleep(Math.abs((int)(Math.random() * 100)));  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                    if(ATOMIC_REFERENCE.compareAndSet("abc" , "abc2" , stamp , stamp + 1)) {  
                        System.out.println("我是线程：" + num + ",我获得了锁进行了对象修改！");  
                    }  
                    lock.unlock();
                }  
            }.start();  
        }

        new Thread() {  
            public void run() {  
                int stamp = ATOMIC_REFERENCE.getStamp();  
                while(!ATOMIC_REFERENCE.compareAndSet("abc2", "abc" , stamp , stamp + 1));  
                System.out.println("已经改回为原始值！");  
            }  
        }.start();
	}

}
