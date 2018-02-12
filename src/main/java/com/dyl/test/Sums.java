package com.dyl.test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Sums {

    static class Sum implements Callable<Long>{

        private final long from;

        private final long to;

        public Sum(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() throws Exception {
            long acc = 0;

            for (long i = from;i<=to;i++){
                acc = acc + i;
            }
            return acc;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<Long>> resultList = executorService.invokeAll(Arrays.asList(new Sum(1L,100L),new Sum(1000L,100010L)));
        executorService.shutdown();

        for (Future<Long> result:resultList){
            System.out.println(result.get());
        }
    }
}
