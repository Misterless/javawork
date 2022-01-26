package mycoffee;

import java.util.ArrayList;

public class Menu {

    // 메뉴 아이템들 (컬렉션)
    private ArrayList<MenuItem> menuItems;

    public Menu(ArrayList<MenuItem> menuitems) {
        this.menuItems = menuitems;
    }

    // 메뉴판에 메뉴가 있는지 찾는 코드
    public MenuItem choose(String menuName) {
        for (MenuItem menuItem : menuItems) { // foreach문은 : 뒤에 배열이 들어가고 배열의 길이만큼 돈다
            if (menuItem.getName().equals(menuName)) {

                // menuItems 리스트 안에 menuName와 같은 이름의 커피가 있다면 리턴
                // (리턴하면 함수를 빠져나간다)
                return menuItem;
            }
        }
        return null;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

}
