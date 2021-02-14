import java.util.function.IntConsumer;

public class Exercise1116 {

    public static void main(String[] args) {
        Exercise1116 o = new Exercise1116(4);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    o.zero(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.print(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    o.even(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.print(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    o.odd(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.print(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private int n;
    private volatile boolean isZero;
    private volatile boolean isOdd;

    public Exercise1116(int n) {
        this.n = n;
        isZero = true;
        isOdd = true;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (!isZero) {
                    this.wait();
                }
                printNumber.accept(0);
                isZero = false;
                this.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            synchronized (this) {
                while (isZero || isOdd) {
                    this.wait();
                }
                printNumber.accept(i);
                isOdd = true;
                isZero = true;
                this.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            synchronized (this) {
                while (isZero || !isOdd){
                    this.wait();
                }
                printNumber.accept(i);
                isOdd = false;
                isZero = true;
                this.notifyAll();
            }
        }
    }
}