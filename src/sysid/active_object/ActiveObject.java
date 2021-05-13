package sysid.active_object;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ActiveObject {
    // container for tasks
    // decides which request to execute next
    // asyncMode=true means our worker thread processes its local task queue in the FIFO order
    // only single thread may modify internal state
    private final ForkJoinPool fj = new ForkJoinPool(1, ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);
    private double val;

    public double getVal() {
        return val;
    }

    // implementation of active object method
    public void doSomething() throws InterruptedException {
        fj.execute(() -> {
            val = 1.0;
            System.out.println("doSomething: Set val: " + val);
        });
    }

    // implementation of active object method
    public void doSomethingElse() throws InterruptedException {
        fj.execute(() -> {
            val = 2.0;
            System.out.println("doSomethingElse: Set val: " + val);
        });
    }

    public void awaitTerminationAfterShutdown() {
        fj.shutdown();
        try {
            if (!fj.awaitTermination(6, TimeUnit.SECONDS)) {
                fj.shutdownNow();
            }
        } catch (InterruptedException ex) {
            fj.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
