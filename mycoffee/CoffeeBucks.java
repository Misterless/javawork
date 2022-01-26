package mycoffee;

import java.util.ArrayList;

public class CoffeeBucks {
    public static void main(String[] args) {

        // 바리스타, 손님 의 생성
        홍길동 홍 = new 홍길동();
        공유 카누 = new 공유();

        // 메뉴 생성과 메뉴판 리스트에 자료를 넣는 것은 바리스타의 일이지만
        // 간략하게 하기위해서 메인에서 작성한다

        // 메뉴 생성
        MenuItem m1 = new MenuItem("아메리카노", 1500);
        MenuItem m2 = new MenuItem("까페라떼", 20000);
        MenuItem m3 = new MenuItem("마끼아또", 3000000);
        MenuItem m4 = new MenuItem("카페모카", 5000);
        // 어레이 리스트에 자료 입력 .add
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(m1);
        menuItems.add(m2);
        menuItems.add(m3);
        menuItems.add(m4);

        // 메뉴 생성
        Menu menu = new Menu(menuItems);

        홍.order(m1.getName(), menu, 카누);
    }
}