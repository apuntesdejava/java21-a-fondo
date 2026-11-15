class Coffee {
    int temperature;
}

public class Demo {
    public static void main(String[] args) {
        Coffee first = new Coffee();
        Coffee second = first;

        first.temperature = 80;

        System.out.println(second.temperature);
    }
}
