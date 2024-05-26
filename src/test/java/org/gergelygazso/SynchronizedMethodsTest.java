package org.gergelygazso;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SynchronizedMethodsTest {

    @Test
    public void invokeNonSyncMethod(){
        ExecutorService service = Executors.newFixedThreadPool(3);
        SynchronizedMethods summation = new SynchronizedMethods();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(summation::calculate));

        //waits until all tasks have completed execution or the timeout reached
        try {
            service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(1000, summation.getSum());
    }

    @Test
    public void invokeSyncMethod(){
        ExecutorService service = Executors.newFixedThreadPool(3);
        SynchronizedMethods summation = new SynchronizedMethods();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(summation::synchronisedCalculate));

        //waits until all tasks have completed execution or the timeout reached
        try {
            service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(1000, summation.getSum());
    }

}
