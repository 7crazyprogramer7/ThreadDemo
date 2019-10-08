package firstdemo;

import sun.awt.windows.ThemeReader;

public class JoinThread {

    static class PrintNum implements Runnable{

        @Override
        public void run() {

            for (int i =1;i<=100;i++){
                System.out.println(i);
                if (i==50){
                    try {
                        Thread thread2 = new Thread(new PrintChar());
                        thread2.start();
                        thread2.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class PrintChar implements Runnable{

        @Override
        public void run() {
            for (int i =1;i<=100;i++){
                System.out.println("a");
            }
        }
    }

    public static void main(String[] args){
        Runnable runnable = new PrintNum();

        Thread thread = new Thread(runnable);
        thread.start();

    }
}
