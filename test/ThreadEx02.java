package test;

public class ThreadEx02 {
    class NewWorker implements Runnable {
        // 타겟
        @Override
        public void run() {
            try {
                for (int i = 1; i < 6; i++) {

                    Thread.sleep(500);
                    System.out.println("뉴워커스레드" + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
    }
        
    
    public static void main(String[] args)

                throws InterruptedException {

            // NewWorker생성

            Thread newWorker = new Thread(new NewWorker());
            newWorker.start();

            for (int i = 1; i < 6; i++) {
                Thread.sleep(500);
                System.out.println("메인스레드" + i);
                Thread.sleep(500);
            }
        }
    }

