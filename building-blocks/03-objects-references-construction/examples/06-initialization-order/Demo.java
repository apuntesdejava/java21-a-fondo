class Robot {

    String first = trace("field 1");

    {
        trace("initializer 1");
    }

    String second = trace("field 2");

    {
        trace("initializer 2");
    }

    Robot() {
        trace("constructor");
    }

    static String trace(String message) {
        System.out.println(message);
        return message;
    }
}

public class Demo {
    public static void main(String[] args) {
        new Robot();
    }
}
