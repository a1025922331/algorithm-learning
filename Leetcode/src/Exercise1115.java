public class Exercise1115 {
    private int n;
    private volatile boolean isFooTurn = true;

    public Exercise1115(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized (this) {
                if (!isFooTurn) {
                    this.wait();
                }
                printFoo.run();
                isFooTurn = false;
                this.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized (this) {
                if (isFooTurn) {
                    this.wait();
                }
                printBar.run();
                isFooTurn = true;
                this.notifyAll();
            }
        }
    }
}