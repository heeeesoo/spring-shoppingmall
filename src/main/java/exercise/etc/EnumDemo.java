package exercise.etc;

public enum EnumDemo {
    AMERICANO(0, "아메리카노"),
    LATTE(1, "라떼"),
    STRAWBERRY_ADE(2, "에이드"),
    ESPRESSO(3, "에스프레소");


    //    americano(0), latte(1), ade(2), espresso(3);
    private final int menu;
    private final String menuName;

    @Override
    public String toString() {
        return "EnumDemo{" +
                "menu=" + menu +
                ", menuName='" + menuName + '\'' +
                '}';
    }

    EnumDemo(int menu, String menuName) {
        this.menu = menu;
        this.menuName = menuName;
    }

    public void selectMenu() {
        System.out.println(menuName);
    }

}
