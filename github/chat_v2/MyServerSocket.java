package github.chat_v2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

public class MyServerSocket {

    ServerSocket serverSocket;
    List<고객전담스레드> 고객리스트;

    MyServerSocket() {
        // 리스너 (연결받기)- 메인스레드

        // 서버는 메시지 받기
        // 클라이언트 숫자만큼
        // 보내기도 필요함
        try {
            serverSocket = new ServerSocket(2000);
            고객리스트 = new Vector<>();

            while (true) {
                Socket socket = serverSocket.accept(); // main thread
                System.out.println("클라이언트 연결됨");
                고객전담스레드 t = new 고객전담스레드(socket);
                고객리스트.add(t);
                System.out.println("고객리스트크기" + 고객리스트.size());
                new Thread(t).start();
                ;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class 고객전담스레드 implements Runnable {
        Socket socket;
        BufferedReader reader;
        BufferedWriter writer;
        boolean isLogin = true;

        public 고객전담스레드(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            while (isLogin) {
                try {
                    String inputData = reader.readLine();
                    System.out.println("from 클라이언트:" + inputData);

                    // 메세지 받았으니 리스트<고객전담리스트> 고객리스트
                    // 에 담긴 모든 클라이언트에게 메세지 전송

                    for (고객전담스레드 t : 고객리스트) {
                        if (t != this) {
                            t.writer.write(inputData + "\n");
                            t.writer.flush();
                        }
                    }
                } catch (Exception e) {

                    try {
                        System.out.println("오류내용:" + e.getMessage());
                        isLogin = false;
                        고객리스트.remove(this);
                        reader.close();
                        writer.close();
                        socket.close();
                    } catch (Exception e1) {
                        System.out.println("연결해제 프로새스 실해" + e1.getMessage());
                    }

                }

            }

        }
    }

    public static void main(String[] args) {
        new MyServerSocket();
    }
}