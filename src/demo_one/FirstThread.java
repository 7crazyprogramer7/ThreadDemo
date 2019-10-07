package demo_one;

public class FirstThread {
    public static void main(String[] args){

    }

    class PrintNum implements Runnable{

        @Override
        public void run() {

           for (int i =1;i<=100;i++){
               System.out.println(i);
           }
        }
    }
    class PrintChar implements Runnable{

        @Override
        public void run() {

            for (int i =1;i<=100;i++){
                System.out.println("a");
            }
        }
    }
}
