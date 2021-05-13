package sysid.active_object;

import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        ActiveObject ao = new ActiveObject();

        Thread t1 = new Thread(() -> {
            try {
                ao.doSomething();
            } catch (InterruptedException e) {
                System.out.println("Error1");
                System.err.println("Error1");
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                ao.doSomething();
            } catch (InterruptedException e) {
                System.out.println("Error2");
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                ao.doSomethingElse();
            } catch (InterruptedException e) {
                System.out.println("Error3");
                e.printStackTrace();
            }
        });
        t3.start();
//        TimeUnit.MICROSECONDS.sleep(3);

        t1.start();
        System.out.println(ao.getVal());
        t2.start();
        System.out.println(ao.getVal());

        TimeUnit.MICROSECONDS.sleep(3);
        ao.awaitTerminationAfterShutdown();

        System.out.println(ao.getVal());
    }
}
