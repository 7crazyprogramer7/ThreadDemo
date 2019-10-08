package firstdemo;


public class FirstThread {
    public static void main(String[] args){
        Runnable runnble1 = new PrintChar();
        Runnable runnable2 = new PrintNum();

        Thread thread1 = new Thread(runnble1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();


    }

    static class PrintNum implements Runnable{

        @Override
        public void run() {

           for (int i =1;i<=100;i++){
               System.out.println(i);
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
}
