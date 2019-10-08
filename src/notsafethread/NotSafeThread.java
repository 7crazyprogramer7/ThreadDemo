package notsafethread;

public class NotSafeThread {

    static class GetTicket implements Runnable {

        private Integer ticketnum;

        public GetTicket(int ticketnum) {

            this.ticketnum = ticketnum;
        }

        /**
         * synchronized关键字在run方法上时，只有一个线程能抢到票，在方法级别进行同步，
         * 只有当前被CPU调度的线程能运行此方法。
         *
         * synchronized关键字在while循环内时，仍然会出现不同线程买到相同的票的情况。
         *
         * synchronized关键字在while循环外时，可以避免不同线程买到相同的票的情况，且不会出现买的负数票。
         *
         */
        @Override
        public void run() {
            synchronized (ticketnum) {
                try {
                    while (ticketnum > 0) {
                        System.out.println(Thread.currentThread().getName() + "--->" + ticketnum--);
                    }
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        int num = 100;
        GetTicket getTicket = new GetTicket(num);
        Thread thread1 = new Thread(getTicket, "a");
        Thread thread2 = new Thread(getTicket, "b");
        Thread thread3 = new Thread(getTicket, "c");

        thread1.start();
        thread2.start();
        thread3.start();

    }

}
