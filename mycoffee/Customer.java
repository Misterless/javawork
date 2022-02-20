package mycoffee;

abstract class Customer {

    public void order(String menuName, Menu menu, Barista barista) {
        /*
         * // 손님 -> 메뉴판에 메시지를 보낸다 (메뉴 호출해줘)
         * MenuItem menuItem = menu.choose(menuName);
         * 
         * if (menuItem == null) {
         * System.out.println(menuName + "은 없는 메뉴입니다.");
         * } else {
         * 
         * // 손님 -> 바리스타에게 메시지를 보낸다 (커피 줘)
         * Coffee coffee = barista.MakeCoffee(menuItem);
         * System.out.println("커피를 받았습니다.");
         * System.out.println(coffee.getName());
         * System.out.println(coffee.getPrice());
         * } 처음에 홍길동 만들기전에 만들었던 고객 지금은 주석으로 잠들다..
         */
    }
}

class 홍길동 extends Customer {
    public void order(String menuName, Menu menu, 공유 barista) {
        String name = "홍길동";
        // 손님 -> 메뉴판에 메시지를 보낸다 (메뉴 호출해줘)
        MenuItem menuItem = menu.choose(menuName);

        if (menuItem == null) {
            System.out.println(menuName + "은 없는 메뉴입니다.");
        } else {

            // 손님 -> 바리스타에게 메시지를 보낸다 (커피 줘)

            Coffee coffee = barista.MakeCoffee(menuItem);

            System.out.println(name + "은 " + coffee.getPrice() + "원 금액의  " + coffee.getName() + "를 받았습니다.");

        }
    }

}