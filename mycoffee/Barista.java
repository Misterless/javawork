package mycoffee;

abstract class Barista {
    abstract Coffee MakeCoffee(MenuItem menuItem);
}

class 공유 extends Barista {
    public Coffee MakeCoffee(MenuItem menuItem) {
        Coffee coffee = new Coffee(menuItem);
        return coffee;
    }
}