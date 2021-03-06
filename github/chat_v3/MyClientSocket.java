package github.chat_v3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClientSocket {

    Socket socket;
    // 스레드
    BufferedWriter writer;
    Scanner sc;
    // 스레드
    BufferedReader reader;

    public MyClientSocket() {
        try {
            socket = new Socket("localhost", 3000);
            sc = new Scanner(System.in);
            writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            new Thread(new 읽기전담스레드()).start();

            // 메인스레드 (쓰기전용)

            while (true) {
                String keyboardInputData = sc.nextLine();
                writer.write(keyboardInputData + "\n");
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2. 이 부분 추가 (클라이언트 소켓쪽)
    /*
     * new Thread(() -> {
     * while (true) {
     * try {
     * String inputData = reader.readLine();
     * System.out.println("받은 메시지 : " + inputData);
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * }
     * }).start();
     * 
     * // 스캐너 달고 (반복x)
     * sc = new Scanner(System.in);
     * // 키보드로부터 입력 받는 부분 (반복)
     * while (true) {
     * String inputData = sc.nextLine();
     * writer.write(inputData + "\n");
     * writer.flush();
     * }
     * 
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * }
     */
    class 읽기전담스레드 implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    String inputData = reader.readLine();
                    System.out.println("받은메세지:" + inputData);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MyClientSocket();
    }
}