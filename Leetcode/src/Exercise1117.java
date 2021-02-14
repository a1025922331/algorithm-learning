import java.util.concurrent.Semaphore;
class Exercise1117 {

    //H执行的条件：需要消耗一个h计数，执行完后产生一个o计数，每累计产生两个O计数可以执行一个O线程
    //O执行的条件：需要消耗两个O计数，执行完成后可以再执行两个H线程，因此产生两个h计数


    //信号量h：当前允许执行的H线程的个数
    //信号量o/2：当前允许执行的O线程的个数
    //两个信号量的初值设置要保证能正常运转下去，又不会破坏规则
    //条件1（不破坏规则）：不能一开始就连续执行两个o线程或者连续执行三个h线程，故h<=2,o<=2
    //条件2（确保能正常运转下去）：
    //                  当o=0时，h=2（这样一开始先执行完两个h线程，o线程也可以执行了，此后即可正常运转）；
    //                  当h=0时，o=2（这样一开始先执行完一个o线程就可以再执行两个h线程了，此后即可正常运转）
    //（条件1 & 条件2）-> 所有的初值可能: (h0,o2)、(h1,o1)、(h1,o2)、(h2,o0)、(h2,o1)、(h2,o2)
    //                                先o、    先h、    谁先都可、 先h、    先h、    谁先都可
    //前5种初值均为固定序列：分别是OHH、HOH、HOH及OHH的组合、HHO、H0H及HHO的组合
    //只有最后一种初值可以实现任意组合
    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(2);

    public Exercise1117() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        o.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        h.release(2);
    }
}
