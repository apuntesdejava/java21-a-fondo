class Coffee {
    final String id;

    Coffee(String id) {
        this.id = id;
    }
}

public class Demo {
    public static void main(String[] args) {
        Coffee coffee = new Coffee("Coffee #1");
        System.out.println(coffee.id);

        coffee = new Coffee("Coffee #2");
        System.out.println(coffee.id);
    }
}
